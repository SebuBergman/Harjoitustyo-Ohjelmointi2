package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Reseptipankki;

public class ReseptipankkiJdbcDao implements ReseptipankkiDao {
	//Löydä kaikki reseptit ominaisuus
	public ArrayList<Reseptipankki> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		ArrayList<Reseptipankki> reseptit = new ArrayList<Reseptipankki>();
		Reseptipankki reseptipankki = null;

		try {
			// Luodaan tietokantayhteys
			connection = Database.getDBConnection();
			String sqlSelect = "SELECT reseptiId, annoksia, reseptinimi, valmistusAika, ainesosat, ohje FROM reseptipankki;";
			statement = connection.prepareStatement(sqlSelect);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				reseptipankki = readReseptipankki(resultset);
				reseptit.add(reseptipankki);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(resultset, statement, connection); // Suljetaan
		}

		return reseptit;
	}
	
	// Read ominaisuus auttaakseen muuttujien lukemisessa
	private Reseptipankki readReseptipankki(ResultSet resultset) {
		try {
			// Reseptipankin muuttujat
			int reseptiId = resultset.getInt("reseptiid");
			String annoksia = resultset.getString("annoksia");
			String reseptiNimi = resultset.getString("reseptiNimi");
			String valmistusAika = resultset.getString("valmistusAika");
			String ainesosat = resultset.getString("ainesosat");
			String ohje = resultset.getString("ohje");

			return new Reseptipankki(reseptiId, annoksia, reseptiNimi, valmistusAika, ainesosat, ohje);
			// Catch mahdollisille virheille ja database yhteyden sulkeminen
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Tietokannasta haku ID:n perusteella. Ei toimi halutusti
	public ArrayList<Reseptipankki> findByID(int reseptiId) {
		Connection connection = null;
		PreparedStatement stmtFind = null;
		ResultSet resultset = null;
		ArrayList<Reseptipankki> resepti = new ArrayList<Reseptipankki>();
		Reseptipankki reseptipankki = new Reseptipankki();
		try {
			// Luodaan tietokantayhteys
			connection = Database.getDBConnection();
			
			String sqlSelectID = "SELECT reseptiId, annoksia, reseptinimi, valmistusAika, ainesosat, ohje FROM reseptipankki WHERE reseptiId = ?";
			stmtFind = connection.prepareStatement(sqlSelectID);

			stmtFind.setInt(1, reseptipankki.getReseptiId());

			resultset = stmtFind.executeQuery();
			while (resultset.next()) {
				reseptipankki = readReseptipankkiById(resultset, reseptiId);
				resepti.add(reseptipankki);
			}
			// Catch mahdollisille virheille ja database yhteyden sulkeminen
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(resultset, stmtFind, connection); // Suljetaan
		}

		return resepti;
	}

	private Reseptipankki readReseptipankkiById(ResultSet resultset, int reseptiId) {
		try {
			// Reseptipankin muuttujat
			String annoksia = resultset.getString("annoksia");
			String reseptiNimi = resultset.getString("reseptiNimi");
			String valmistusAika = resultset.getString("valmistusAika");
			String ainesosat = resultset.getString("ainesosat");
			String ohje = resultset.getString("ohje");

			return new Reseptipankki(reseptiId, annoksia, reseptiNimi, valmistusAika, ainesosat, ohje);
			// Catch mahdollisille virheille ja database yhteyden sulkeminen
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Add resepti metodi jolla lisätään reseptit tietokantaan
	public boolean addResepti(Reseptipankki reseptipankki) {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		boolean updateSuccessed = false;

		try {
			// Luodaan tietokantayhteys
			connection = Database.getDBConnection();
			// SQL komento lisäykselle
			String sqlInsert = "INSERT INTO reseptipankki (annoksia, reseptiNimi, valmistusAika, ainesosat, ohje) VALUES (?, ?, ?, ?, ?)";

			stmtInsert = connection.prepareStatement(sqlInsert);
			//lisättään muuttujiin tieto
			stmtInsert.setString(1, reseptipankki.getAnnoksia());
			stmtInsert.setString(2, reseptipankki.getReseptiNimi());
			stmtInsert.setString(3, reseptipankki.getValmistusAika());
			stmtInsert.setString(4, reseptipankki.getAinesosat());
			stmtInsert.setString(5, reseptipankki.getOhje());

			int rowAffected = stmtInsert.executeUpdate();
			if (rowAffected == 1)
				updateSuccessed = true;
			// Catch mahdollisille virheille ja database yhteyden sulkeminen
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtInsert, connection);
		}
		return updateSuccessed;
	}

	// Remove resepti metodi jolla poistetaan ID:n avulla reseptit tietokannasta
	public boolean removeResepti(int reseptiId) {
		Connection connection = null;
		PreparedStatement stmtDelete = null;
		boolean updateSuccessed = false;

		try {
			// Luodaan tietokantayhteys
			connection = Database.getDBConnection();
			// SQL komento poistolle
			String sqlDelete = "DELETE FROM reseptipankki WHERE reseptiId = ?";
			stmtDelete = connection.prepareStatement(sqlDelete);

			stmtDelete.setInt(1, reseptiId);

			int rowAffected = stmtDelete.executeUpdate();
			if (rowAffected == 1)
				updateSuccessed = true;
			// Catch mahdollisille virheille ja database yhteyden sulkeminen
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtDelete, connection);
		}
		return updateSuccessed;
	}

	// Update tai muokkaus ominaisuus (Ei hae tietoja muokkauslomakkeelle)
	public boolean muokkaaResepti(Reseptipankki reseptipankki) {
		Connection connection = null;
		PreparedStatement stmtUpdate = null;
		boolean updateSuccessed = false;

		try {
			// Luodaan tietokantayhteys
			connection = Database.getDBConnection();
			// SQL komento päivitykselle
			String sqlUpdate = "UPDATE reseptipankki SET annoksia = ?, reseptiNimi = ?, valmistusAika = ?, ainesosat =?, ohje = ? WHERE reseptiId = ?";
			stmtUpdate = connection.prepareStatement(sqlUpdate);

			stmtUpdate.setString(1, reseptipankki.getAnnoksia());
			stmtUpdate.setString(2, reseptipankki.getReseptiNimi());
			stmtUpdate.setString(3, reseptipankki.getValmistusAika());
			stmtUpdate.setString(4, reseptipankki.getAinesosat());
			stmtUpdate.setString(5, reseptipankki.getOhje());
			stmtUpdate.setInt(6, reseptipankki.getReseptiId());

			/* */
			int rowAffected = stmtUpdate.executeUpdate();
			if (rowAffected == 1)
				updateSuccessed = true;

			// Catch mahdollisille virheille ja database yhteyden sulkeminen
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtUpdate, connection);
		}
		return updateSuccessed;
	}
}