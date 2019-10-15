package com.vistalis.computerdictionary.Repositories;

import android.content.Context;

import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.Word;

public class WordRepository {

    private static void create(Context context, String word, String translation, int dialect)
    {
        Word wordModel = new Word(word,translation, dialect);
        DB.getInstance(context).wordsDao().create(wordModel);
    }


    private static void insertCebuanoWords(Context context)
    {
        WordRepository.create(context,"I","Ako", 2);
        WordRepository.create(context,"You","Ikaw", 2);
        WordRepository.create(context,"Mine","Akoa", 2);
        WordRepository.create(context,"Ours","Kita", 2);
        WordRepository.create(context,"There's","Adunay", 2);
        WordRepository.create(context,"Your's","Imong", 2);
        WordRepository.create(context,"Eat","Kaon", 2);
        WordRepository.create(context,"Sleep","Pagkatulog", 2);
        WordRepository.create(context,"Run","Pagdagan", 2);
        WordRepository.create(context,"Enter","Pagsulod", 2);
        WordRepository.create(context,"In love","Sa Gugma", 2);
        WordRepository.create(context,"Walk","lakaw", 2);
        WordRepository.create(context,"push","pagduso", 2);
        WordRepository.create(context,"old","tigulang na", 2);
        WordRepository.create(context,"generous","manggihatagon", 2);
        WordRepository.create(context,"brave","maisog", 2);
        WordRepository.create(context,"funny","kataw-anan", 2);
        WordRepository.create(context,"evil","daotan", 2);
        WordRepository.create(context,"rich","dato", 2);
        WordRepository.create(context,"poor","kabus", 2);
        WordRepository.create(context,"shy","maulaw", 2);
        WordRepository.create(context,"ugly","pangit", 2);
        WordRepository.create(context,"dirty","hugaw", 2);
        WordRepository.create(context,"clean","limpyo", 2);
        WordRepository.create(context,"handsome","gwapo", 2);
        WordRepository.create(context,"smiling","nagpahiyom", 2);
        WordRepository.create(context,"beautiful","matahum", 2);
        WordRepository.create(context,"slouch","pahuway", 2);
        WordRepository.create(context,"Tense","Labi", 2);
        WordRepository.create(context,"short","mubo", 2);
        WordRepository.create(context,"tall","taas", 2);
        WordRepository.create(context,"big","dako", 2);
        WordRepository.create(context,"skinny","panit", 2);
        WordRepository.create(context,"small","gamay", 2);
        WordRepository.create(context,"deep","lawom", 2);
        WordRepository.create(context,"wide","sa gilapdon", 2);
        WordRepository.create(context,"roud","makusog", 2);
        WordRepository.create(context,"straight","tul-id", 2);
        WordRepository.create(context,"spicy","maanindot", 2);
        WordRepository.create(context,"salty","asin", 2);
        WordRepository.create(context,"sweet","matam-is", 2);
        WordRepository.create(context,"bitter","pait", 2);
        WordRepository.create(context,"harug","harug", 2);
        WordRepository.create(context,"cold","kabugnaw", 2);
        WordRepository.create(context,"hot","init", 2);
        WordRepository.create(context,"soft","humok", 2);
        WordRepository.create(context,"hard","lisud", 2);
        WordRepository.create(context,"dry","uga nga", 2);
        WordRepository.create(context,"smooth","hamis nga", 2);
        WordRepository.create(context,"rought","gihunahuna", 2);
        WordRepository.create(context,"wet","basa", 2);
        WordRepository.create(context,"silent","hilom", 2);
        WordRepository.create(context,"loud","kusog", 2);
        WordRepository.create(context,"noisy","lanog", 2);
        WordRepository.create(context,"awful","makalilisang", 2);
        WordRepository.create(context,"tingog","kinabuhi", 2);
        WordRepository.create(context,"whisper","paghunghong", 2);
        WordRepository.create(context,"few","diyutay", 2);
        WordRepository.create(context,"some","pipila", 2);
        WordRepository.create(context,"multiple","daghang", 2);
        WordRepository.create(context,"plenty","daghan", 2);
        WordRepository.create(context,"many","daghan", 2);
        WordRepository.create(context,"one","sa usa ka", 2);
        WordRepository.create(context,"several","ubay-ubay", 2);
        WordRepository.create(context,"each","matag usa", 2);
        WordRepository.create(context,"all","tanan", 2);
        WordRepository.create(context,"nasty","dili maayo", 2);
        WordRepository.create(context,"waiting","naghulat", 2);
        WordRepository.create(context,"horrible","makalilisang", 2);
        WordRepository.create(context,"artisimple","artipisyal", 2);
        WordRepository.create(context,"doubtfully","pagduhaduha", 2);
        WordRepository.create(context,"rainy","ulan,", 2);
        WordRepository.create(context,"dangerous","delikado", 2);
        WordRepository.create(context,"angry","nasuko", 2);
        WordRepository.create(context,"hurt","nasakitan", 2);
        WordRepository.create(context,"selfish","hakog", 2);
        WordRepository.create(context,"scary","makahadlok", 2);
        WordRepository.create(context,"confused","naglibog", 2);
        WordRepository.create(context,"tired","gikapoy", 2);
        WordRepository.create(context,"embarass","panghimaraot", 2);
        WordRepository.create(context,"afraid","nahadlok", 2);
        WordRepository.create(context,"lazy","tapolan", 2);
    }

    private static void insertKamayoWords(Context context)
    {

        WordRepository.create(context,"I","Ako", 1);
        WordRepository.create(context,"You","Ikaw", 1);
        WordRepository.create(context,"Mine","Kanak", 1);
        WordRepository.create(context,"Ours","Kanato", 1);
        WordRepository.create(context,"There's","Kaniran", 1);
        WordRepository.create(context,"He/She","Si-an", 1);
        WordRepository.create(context,"Your's","Kanmo", 1);
        WordRepository.create(context,"Eat","Kaan", 1);
        WordRepository.create(context,"Sleep","Turo", 1);
        WordRepository.create(context,"Run","Dagan", 1);
        WordRepository.create(context,"Enter","Panik", 1);
        WordRepository.create(context,"In love","Yahimaya", 1);
        WordRepository.create(context,"Walk","Panaw", 1);
        WordRepository.create(context,"See","Tanaw", 1);
        WordRepository.create(context,"Touch","Hawid", 1);
        WordRepository.create(context,"Hear","Yadungog", 1);
        WordRepository.create(context,"Forget","Yakalingaw", 1);
        WordRepository.create(context,"Drunk","Yahingaw", 1);
        WordRepository.create(context,"Fall","Yahuog", 1);
        WordRepository.create(context,"Laugh","Hikowo", 1);
        WordRepository.create(context,"Cry","Tiyaho", 1);
        WordRepository.create(context,"Follow","Gihud", 1);
        WordRepository.create(context,"Talk","Tiyab", 1);
        WordRepository.create(context,"Know","Matigam", 1);
        WordRepository.create(context,"Prepare","Yagahigay", 1);
        WordRepository.create(context,"Many/Much","Daigay", 1);
        WordRepository.create(context,"Big","Badi", 1);
        WordRepository.create(context,"Very Big","Badihay", 1);
        WordRepository.create(context,"Beautiful","Gwapa", 1);
        WordRepository.create(context,"Very Beautiful","Gwapahay", 1);
        WordRepository.create(context,"Small/little","Tabibi", 1);
        WordRepository.create(context,"Very Small","Tabibi-ay", 1);
        WordRepository.create(context,"Old","Hinood", 1);
        WordRepository.create(context,"Fast","Kusogay", 1);
        WordRepository.create(context,"Heavy","Bug-atay", 1);
        WordRepository.create(context,"Ugly","Maraat", 1);
        WordRepository.create(context,"Very Ugly","Maraatay", 1);
        WordRepository.create(context,"Greedy","Gawot", 1);
        WordRepository.create(context,"Cold","Tignaw", 1);
        WordRepository.create(context,"Hot","Mapaso", 1);
        WordRepository.create(context,"Near","Harapit", 1);
        WordRepository.create(context,"Far","Harayo", 1);
        WordRepository.create(context,"Dirty","Maripa", 1);
        WordRepository.create(context,"Dark","Maduggom", 1);
        WordRepository.create(context,"Here","Adi / Ngani	", 1);
        WordRepository.create(context,"There","Ngadto", 1);
        WordRepository.create(context,"Nothing","Ampan / Wara", 1);
        WordRepository.create(context,"Have","Aron", 1);
        WordRepository.create(context,"Maybe","Basi / Basin", 1);
        WordRepository.create(context,"Put","Butang", 1);
        WordRepository.create(context,"Where","Hain", 1);
        WordRepository.create(context,"That","Idtu", 1);
        WordRepository.create(context,"I Don't Know","Inday", 1);
        WordRepository.create(context,"This","Ini / Ngini", 1);
        WordRepository.create(context,"That is","Itun", 1);
        WordRepository.create(context,"Take","Kamang", 1);
        WordRepository.create(context,"When","Kinu", 1);
        WordRepository.create(context,"Good","Madayaw", 1);
        WordRepository.create(context,"Ugly","Maraat", 1);
        WordRepository.create(context,"Why","Nanga sa", 1);
        WordRepository.create(context,"What","Unaan / Naan", 1);
        WordRepository.create(context,"How Much","Pila", 1);
        WordRepository.create(context,"Who","Sinu / Sin-u", 1);
        WordRepository.create(context,"Give","Tagi", 1);
        WordRepository.create(context,"How","Unuhon", 1);
        WordRepository.create(context,"None","Wara", 1);
        WordRepository.create(context,"Child","Isu", 1);
        WordRepository.create(context,"Old person","hinuod", 1);
        WordRepository.create(context,"Nose","Irong", 1);
        WordRepository.create(context,"Yes","Huo", 1);
        WordRepository.create(context,"No","Diri", 1);
        WordRepository.create(context,"Face","Bayho", 1);
        WordRepository.create(context,"Hand","Alima", 1);
        WordRepository.create(context,"Foot","Siki", 1);
        WordRepository.create(context,"Thigh","Paa", 1);
        WordRepository.create(context,"Son","Isu son", 1);
        WordRepository.create(context,"Help","Tabang", 1);
        WordRepository.create(context,"speaker","Mangabugaray/presentor", 1);
        WordRepository.create(context,"mat","hikam", 1);
        WordRepository.create(context,"pregnant","kabdus", 1);
        WordRepository.create(context,"coins","sinsilyo", 1);
        WordRepository.create(context,"blanket","sabanas", 1);
        WordRepository.create(context,"fire","atun", 1);
        WordRepository.create(context,"hand","alima", 1);
        WordRepository.create(context,"image","bayhu", 1);
        WordRepository.create(context,"broom","baslay", 1);
        WordRepository.create(context,"play","Duwa ", 1);
        WordRepository.create(context,"bite","Banga ", 1);
        WordRepository.create(context,"wash","Laba", 1);
        WordRepository.create(context,"pounch","Sumbag", 1);
        WordRepository.create(context,"harvest","Garab ", 1);
        WordRepository.create(context,"kiss","Haruk", 1);
        WordRepository.create(context,"climb","Katkat ", 1);
        WordRepository.create(context,"catch","Labyog ", 1);
        WordRepository.create(context,"trim","Lampas", 1);
        WordRepository.create(context,"hold","Hawid ", 1);
        WordRepository.create(context,"pick","Kamang ", 1);
        WordRepository.create(context,"kick","Sipa", 1);
        WordRepository.create(context,"fall","Kagtang ", 1);
        WordRepository.create(context,"push","Tud", 1);
        WordRepository.create(context,"old","hinuud", 1);
        WordRepository.create(context,"generous","parahatag", 1);
        WordRepository.create(context,"brave","isog", 1);
        WordRepository.create(context,"funny","kataw-anan", 1);
        WordRepository.create(context,"evil","satanas ", 1);
        WordRepository.create(context,"rich","kwartahan", 1);
        WordRepository.create(context,"poor","pubri", 1);
        WordRepository.create(context,"shy","sipogon", 1);
        WordRepository.create(context,"ugly","raat", 1);
        WordRepository.create(context,"dirty","ripa", 1);
        WordRepository.create(context,"clean","mahinlu", 1);
        WordRepository.create(context,"handsome","guapo", 1);
        WordRepository.create(context,"smiling","ngisi", 1);
        WordRepository.create(context,"beautiful","gwapa", 1);
        WordRepository.create(context,"slouch","bayuku", 1);
        WordRepository.create(context,"Tense","alingasa", 1);
        WordRepository.create(context,"short","hayupu", 1);
        WordRepository.create(context,"tall","haba", 1);
        WordRepository.create(context,"big","badi", 1);
        WordRepository.create(context,"skinny","kaig", 1);
        WordRepository.create(context,"small","gamay", 1);
        WordRepository.create(context,"deep","lawum", 1);
        WordRepository.create(context,"wide","hawag", 1);
        WordRepository.create(context,"roud","limun", 1);
        WordRepository.create(context,"straight","tul-id", 1);
        WordRepository.create(context,"spicy","harang", 1);
        WordRepository.create(context,"salty","parat", 1);
        WordRepository.create(context,"sour","aslum", 1);
        WordRepository.create(context,"sweet","tam–is", 1);
        WordRepository.create(context,"bitter","pait", 1);
        WordRepository.create(context,"harug","Half-cook", 1);
        WordRepository.create(context,"cold","tignaw", 1);
        WordRepository.create(context,"hot","pasu", 1);
        WordRepository.create(context,"soft","humuk", 1);
        WordRepository.create(context,"hard","gahi", 1);
        WordRepository.create(context,"dry","tahay", 1);
        WordRepository.create(context,"smooth","hanut", 1);
        WordRepository.create(context,"rought","gurud-gurud", 1);
        WordRepository.create(context,"wet","wetbasa ", 1);
        WordRepository.create(context,"shinny","kinlaw", 1);
        WordRepository.create(context,"silent","hilum", 1);
        WordRepository.create(context,"loud","kusug", 1);
        WordRepository.create(context,"noisy","saba", 1);
        WordRepository.create(context,"awful","libag", 1);
        WordRepository.create(context,"tingog","waray", 1);
        WordRepository.create(context,"whisper","hagas", 1);
        WordRepository.create(context,"few","hamuk", 1);
        WordRepository.create(context,"some","hamuk", 1);
        WordRepository.create(context,"multiple","hamuk", 1);
        WordRepository.create(context,"plenty","hamuk", 1);
        WordRepository.create(context,"many","hamuk", 1);
        WordRepository.create(context,"one","isa", 1);
        WordRepository.create(context,"several","hamuk", 1);
        WordRepository.create(context,"each","isa", 1);
        WordRepository.create(context,"all","hurut", 1);
        WordRepository.create(context,"nasty","bastus", 1);
        WordRepository.create(context,"waiting","huya", 1);
        WordRepository.create(context,"alchoholic","parahubog", 1);
        WordRepository.create(context,"horrible","kahadukan", 1);
        WordRepository.create(context,"artisimple","waray", 1);
        WordRepository.create(context,"doubtfully","duda", 1);
        WordRepository.create(context,"rainy","uran", 1);
        WordRepository.create(context,"dangerous","delikado", 1);
        WordRepository.create(context,"angry","daman", 1);
        WordRepository.create(context,"hurt","sakitan", 1);
        WordRepository.create(context,"selfish","awaan", 1);
        WordRepository.create(context,"scary","kahadlukan", 1);
        WordRepository.create(context,"confused","libog", 1);
        WordRepository.create(context,"tired","kapuy", 1);
        WordRepository.create(context,"embarass","sipog", 1);
        WordRepository.create(context,"afraid","haduk", 1);
        WordRepository.create(context,"lazy","puluhu", 1);
    }


    public static void insertAllWords(Context context)
    {
        DB.getInstance(context).wordsDao().deleteAllWords();
        WordRepository.insertCebuanoWords(context);
        WordRepository.insertKamayoWords(context);
    }

    public static Word pickWord(Context context, String word, int dialect)
    {
        return DB.getInstance(context).wordsDao().pickWordByDialect(word, dialect);
    }

    public static int availableWord(Context context, String word, int dialect)
    {
        return DB.getInstance(context).wordsDao().hasPickWord(word, dialect);
    }

}