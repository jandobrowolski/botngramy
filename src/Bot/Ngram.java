package Bot;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Janek
 */
public class Ngram {
	private ArrayList<String> baza;
	private ArrayList<Integer> rozdzielacz;
	private ArrayList<String> wyniki;
	public Ngram()
	{
		baza = new ArrayList<>();
		rozdzielacz = new ArrayList<>();
		wyniki = new ArrayList<>();
	}
	public Ngram( ArrayList<String> baza, ArrayList<Integer> rozdzielacz)
	{
		baza = new ArrayList<>();
		rozdzielacz = new ArrayList<>();
		wyniki = new ArrayList<>();
	}
	public String getWord(int n)
	{
		return baza.get(n);
	}
	public void addWord(String n)
	{
		baza.add(n);
	}
	public void addResultWord(String n)
	{
		wyniki.add(n);
	}
	public void endBase()
	{
		rozdzielacz.add(baza.size()-1);
	}
	public String getResult()
	{
		String s = new String();
		for(String w : wyniki)
			s += w + " ";
		return s;
	}
	public int size()
	{
		return baza.size();
	}
	public boolean isSizeLimitReached()
	{
		return wyniki.size() >= 15;
	}
	public void clearResult()
	{
		wyniki.clear();
	}
	public boolean hasBaseEnded(int ktorywyraz)
	{
		for(Integer przedzial : rozdzielacz)
			if(przedzial <= ktorywyraz)
				return true;
		return false;
	}
	public void addBase(String [] words)
	{
		if(words[0].isEmpty())
			return;
		for(String word : words)
		{
			addWord(word);
		}
		endBase();
	}
}
