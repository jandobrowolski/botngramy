package Bot;


import Bot.Ngram;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Janek
 */
public class Generate {
	private Ngram ngram;
	private int ktorywyraz;
	private ArrayList<Integer> wynikowe;
	public Generate()
	{
	}
	public void work(Ngram ngram)
	{
		this.ngram = ngram;
		wynikowe = new ArrayList();
		Random generator = new Random();
		ktorywyraz = generator.nextInt(ngram.size());
		while(!ngram.isSizeLimitReached() && !ngram.hasBaseEnded(ktorywyraz))
		{
			wynikowe.clear();
			for (int i=0; i<ngram.size(); i++)
			{
				if((ngram.getWord(i)).equals(ngram.getWord(ktorywyraz)))
				{
					wynikowe.add(i);
				}
			}
			if(!wynikowe.isEmpty())
			{
				ktorywyraz = wynikowe.get(generator.nextInt(wynikowe.size()));
				
				while(ngram.getWord(ktorywyraz+1).endsWith("?"))
				{
					ktorywyraz = wynikowe.get(generator.nextInt(wynikowe.size()));
				}
				for(int i=1; i<2 ; i++)
				{
					ngram.addResultWord(ngram.getWord(ktorywyraz+i));
				}
				ktorywyraz+=1;
			}
			else
			{
				return;
			}
		}
	}
	
}
