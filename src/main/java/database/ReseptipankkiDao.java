package database;

import java.util.ArrayList;

import model.Reseptipankki;

public interface ReseptipankkiDao {
	public ArrayList<Reseptipankki> findAll();
	
	public ArrayList<Reseptipankki> findByID(int reseptiId);
	
	public boolean addResepti(Reseptipankki reseptipankki);
	
	public boolean removeResepti(int reseptiId);
	
	public boolean muokkaaResepti(Reseptipankki reseptipankki);
}