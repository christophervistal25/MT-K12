package com.vistalis.computerdictionary.Repositories;

import android.content.Context;

import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.DatabaseModules.Models.Phrase;
import com.vistalis.computerdictionary.DatabaseModules.Models.Word;

public class PhraseRepository {

    public static void create(Context context, String word, String translation, int dialect)
    {
        Phrase phraseModel = new Phrase(word,translation, dialect);
        DB.getInstance(context).phraseDao().create(phraseModel);
    }


    private static void insertPharses(Context context)
    {
        PhraseRepository.create(context,"Hello!","Oy!", 2);
        PhraseRepository.create(context,"Oh no!","Ayaw intawon!", 2);
        PhraseRepository.create(context,"No way!","Dili puyde!", 2);
        PhraseRepository.create(context,"Go away!","Layas!", 2);
        PhraseRepository.create(context,"Go away.","Layas.", 2);
        PhraseRepository.create(context,"Goodbye!","Pag-ayo-ayo dinhi!", 2);
        PhraseRepository.create(context,"Shut up!","Hilom!", 2);
        PhraseRepository.create(context,"Shut up!","Hilom diha!", 2);
        PhraseRepository.create(context,"Welcome.","Maayong pag-abot!", 2);
        PhraseRepository.create(context,"Hurry up.","Pagdali.", 2);
        PhraseRepository.create(context,"Let's go!","Ta na!", 2);
        PhraseRepository.create(context,"Let's go!","Tana!", 2);
        PhraseRepository.create(context,"Come here.","'Mari ka.", 2);
        PhraseRepository.create(context,"Come here.","Mari ka.", 2);
        PhraseRepository.create(context,"I'm sorry.","Pasayloa ko.", 2);
        PhraseRepository.create(context,"I'm tired.","Gikapoy ko.", 2);
        PhraseRepository.create(context,"I love you.","Gihigugma ta ka.", 2);
        PhraseRepository.create(context,"I'm hungry!","Gigutom ko.", 2);
        PhraseRepository.create(context,"We're fair.","Makiangayon man mi.", 2);
        PhraseRepository.create(context,"We're fine.","Maayo man mi.", 2);
        PhraseRepository.create(context,"We're here.","Dia ra mi.", 2);
        PhraseRepository.create(context,"We're home.","Nia mi sa balay.", 2);
        PhraseRepository.create(context,"We're late.","Ulahi mi.", 2);
        PhraseRepository.create(context,"We're lazy.","Tapolan mi.", 2);
        PhraseRepository.create(context,"We're lost.","Nasaagmi.", 2);
        PhraseRepository.create(context,"We're poor.","Kabos mi.", 2);
        PhraseRepository.create(context,"We're rich.","Dato mi.", 2);
        PhraseRepository.create(context,"We're safe.","Luwas mi.", 2);
        PhraseRepository.create(context,"We're sick.","Masakiton mi.", 2);
        PhraseRepository.create(context,"We're sunk.","Naunlod mi.", 2);
        PhraseRepository.create(context,"We're tidy.","Himos mi.", 2);
        PhraseRepository.create(context,"We're weak.","Huyang mi.", 2);
        PhraseRepository.create(context,"What a day!","Grabeng adlawa!", 2);
        PhraseRepository.create(context,"What's new?","Unsay bag-o?", 2);
        PhraseRepository.create(context,"Who are we?","Si kinsa ba kita?", 2);
        PhraseRepository.create(context,"Who did it?","Kinsay mibuhat ato?", 2);
        PhraseRepository.create(context,"Who has it?","Kinsay naay ing-ato?", 2);
        PhraseRepository.create(context,"Who is Tom?","Kinsa nang Tom?", 2);
        PhraseRepository.create(context,"Who is she?","Kinsa na siya?", 2);
        PhraseRepository.create(context,"Who phoned?","Kinsay nanawag?", 2);
        PhraseRepository.create(context,"Who saw me?","Kinsa toy nakakita nako?", 2);
        PhraseRepository.create(context,"Who stayed?","Kinsay nabilin?", 2);
        PhraseRepository.create(context,"Who talked?","Kinsay misulti?", 2);
        PhraseRepository.create(context,"Who was it?","Kinsa gani to?", 2);
        PhraseRepository.create(context,"Who yelled?","Kinsay misiyagit?", 2);
        PhraseRepository.create(context,"Who's here?","Kinsay nia?", 2);
        PhraseRepository.create(context,"Who's next?","Kinsay sunod?", 2);
        PhraseRepository.create(context,"Who's that?","Kinsa na?", 2);
        PhraseRepository.create(context,"Wood burns.","Ang kahoy mosilaob.", 2);
        PhraseRepository.create(context,"You can go.","Adto kaw.", 2);
        PhraseRepository.create(context,"You did it.","Nabuhat mo.", 2);
        PhraseRepository.create(context,"You got it.","Sakto ka.", 2);
        PhraseRepository.create(context,"You may go.","Puyde ka nang mohawa.", 2);
        PhraseRepository.create(context,"You missed.","Sipyat ka.", 2);
        PhraseRepository.create(context,"Don't worry.","Ayawg kaguol.", 2);
        PhraseRepository.create(context,"How are you?","Unsa na man?", 2);
        PhraseRepository.create(context,"How are you?","Kumusta?", 2);
        PhraseRepository.create(context,"I'm thirsty.","Giuhaw ko.", 2);
        PhraseRepository.create(context,"Who are you?","Kinsa diay ka?", 2);
        PhraseRepository.create(context,"A bug bit me.","Gipaak ka ba og insekto?", 2);
        PhraseRepository.create(context,"Are you sure?","Segurado ka?", 2);
        PhraseRepository.create(context,"I am curious.","Buot ko masayod.", 2);
        PhraseRepository.create(context,"I don't know.","Ambot.", 2);
        PhraseRepository.create(context,"I want to go.","Moadto na ko.", 2);
        PhraseRepository.create(context,"Are you happy?","Malipayon ka ba?", 2);
        PhraseRepository.create(context,"Are you tired?","Gikapoy ka?", 2);
        PhraseRepository.create(context,"He got caught.","Gidakop siya.", 2);
        PhraseRepository.create(context,"We have a dog.","Duna miy iro.", 2);
        PhraseRepository.create(context,"Where are you?","Hain ka karon?", 2);
        PhraseRepository.create(context,"Are you hungry?","Gigutom ka?", 2);
        PhraseRepository.create(context,"Can I help you?","Tabangan ta ka na?", 2);
        PhraseRepository.create(context,"Do you love me?","Imo ba kong gihigugma?", 2);
        PhraseRepository.create(context,"Happy New Year!","Bulahang Bag-ong Tuig!", 2);
        PhraseRepository.create(context,"Leave me alone!","Pasagdi ko!", 2);
        PhraseRepository.create(context,"Please join me.","Palihog nunot kanako.", 2);
        PhraseRepository.create(context,"Please move on.","Sibog na intawon.", 2);
        PhraseRepository.create(context,"Are you married?","Minyo ka ba?", 2);
        PhraseRepository.create(context,"Congratulations!","Pahalipay!", 2);
        PhraseRepository.create(context,"Congratulations!","Pasidungog!", 2);
        PhraseRepository.create(context,"How old are you?","Pilay imong edad?", 2);
        PhraseRepository.create(context,"I have two cats.","Duhay akong iring.", 2);
        PhraseRepository.create(context,"Please continue.","Padayon palihog.", 2);
        PhraseRepository.create(context,"Please sit down.","Palihog lingkod.", 2);
        PhraseRepository.create(context,"Please visit me.","Duawa ko palihog.", 2);
        PhraseRepository.create(context,"They won't know.","Dili sila kabalo.", 2);
        PhraseRepository.create(context,"Do you live here?","Taga dinhi ka?", 2);
        PhraseRepository.create(context,"I hate chemistry.","Dili ko ganahan og Kemistri.", 2);
        PhraseRepository.create(context,"I'm not a doctor.","Dili ko doktor.", 2);
        PhraseRepository.create(context,"What do you want?","Unsay imong gusto?", 2);
        PhraseRepository.create(context,"What's your name?","Unsay imong ngalan?", 2);
        PhraseRepository.create(context,"I have a headache.","Gilabdan ko.", 2);
        PhraseRepository.create(context,"I was not pleased.","Wala ko mahimuot.", 2);
        PhraseRepository.create(context,"Please just leave.","Palihog hawa.", 2);
        PhraseRepository.create(context,"Please stop there.","Hunong diha palihog.", 2);
        PhraseRepository.create(context,"What is your name?","Unsay imong ngalan?", 2);
        PhraseRepository.create(context,"Where do you live?","Diiy inyo?", 2);
        PhraseRepository.create(context,"I don't understand.","Wala ko kasabot.", 2);
        PhraseRepository.create(context,"Please call a taxi.","Kuha palihog og taxi.", 2);
        PhraseRepository.create(context,"Please come hungry.","Ari intawon nga gutom.", 2);
        PhraseRepository.create(context,"Please don't leave.","Ayaw intawon hawa.", 2);
        PhraseRepository.create(context,"Please give me one.","Tagai kog usa bi.", 2);
        PhraseRepository.create(context,"Please wait for me.","Palihog og hulat nako.", 2);
        PhraseRepository.create(context,"What are you doing?","Nag-unsa ka?", 2);
        PhraseRepository.create(context,"Where are you from?","Dis-a ka?", 2);
        PhraseRepository.create(context,"Why are you crying?","Nganong mihilak ka?", 2);
        PhraseRepository.create(context,"I will be back soon.","Mobalik ra ko dayon.", 2);
        PhraseRepository.create(context,"Please come quickly.","Pagdali intawon.", 2);
        PhraseRepository.create(context,"Please fix the iron.","Itarong ra ko sa plancha.", 2);
        PhraseRepository.create(context,"Please have a drink.","Tagay palihog.", 2);
        PhraseRepository.create(context,"Please just go away.","Palihog hawa lang.", 2);
        PhraseRepository.create(context,"Please sell me that.","Ibaligya intawon na ngari nako.", 2);
        PhraseRepository.create(context,"The engine is noisy.","Kasaba ba sa motor.", 2);
        PhraseRepository.create(context,"Tom decided to wait.","Nakahukom si Tom nga magpaabot.", 2);
        PhraseRepository.create(context,"Where are you going?","Asa ka moadto?", 2);
        PhraseRepository.create(context,"I want to please you.","Gusto ko malipayon ka.", 2);
        PhraseRepository.create(context,"Please don't hang up.","Palihog ayawg ibutang.", 2);
        PhraseRepository.create(context,"Please don't hurt me.","Ayaw intawon ko pasakiti.", 2);
        PhraseRepository.create(context,"Please drop in on us.","Hapit intawon namo.", 2);
        PhraseRepository.create(context,"Please eat something.","Palihog ayaw usag kaon.", 2);
        PhraseRepository.create(context,"Please read it again.","Basaha palihog og usob.", 2);
        PhraseRepository.create(context,"Tom didn't act alone.","Dili to inusarang gibuhat ni Tom.", 2);
        PhraseRepository.create(context,"How long did you stay?","Unsa ka kadugaya didto?", 2);
        PhraseRepository.create(context,"It was nobody's fault.","Walay sad-an sa nahitabo.", 2);
        PhraseRepository.create(context,"Please don't tell Tom.","Ayaw intawon tug-ani si Tom.", 2);
        PhraseRepository.create(context,"She is afraid of cats.","Mahadlok siyag iring.", 2);
        PhraseRepository.create(context,"I don't have any money.","Wala na jud koy kwarta.", 2);
        PhraseRepository.create(context,"I don't speak Japanese.","Dili ko makahinapon.", 2);
        PhraseRepository.create(context,"Wait for a few seconds.","Wetsa.", 2);
        PhraseRepository.create(context,"Which film did you see?","Asang salidahay imong gitan-aw?", 2);
        PhraseRepository.create(context,"You asked for my advice.","Nagpakitambag ka kanako.", 2);
        PhraseRepository.create(context,"Do you know how to do it?","Kamao ka?", 2);
        PhraseRepository.create(context,"I don't like you anymore.","Wala na koy gusto nimo.", 2);
        PhraseRepository.create(context,"I'm living in Boston now.","Napuyo ko ron sa Boston.", 2);
        PhraseRepository.create(context,"The book is on the table.","Toa ang libro sa lamesa.", 2);
        PhraseRepository.create(context,"You be the judge of that.","Ikay hukom niana.", 2);
        PhraseRepository.create(context,"I have to go to the toilet.","Kinahanglang moadto ko sa pansayan.", 2);
        PhraseRepository.create(context,"The archer killed the deer.","Napatay sa tigpana ang lagsaw.", 2);
        PhraseRepository.create(context,"Tom was taken into custody.","Gibilanggo si Tom.", 2);
        PhraseRepository.create(context,"What are you talking about?","Unsay buot mong ipasabot?", 2);
        PhraseRepository.create(context,"I shouldn't have logged off.","Wala lang usa ko mobiya.", 2);
        PhraseRepository.create(context,"There is a meeting tomorrow.","May tigom ugma.", 2);
        PhraseRepository.create(context,"Why don't you come visit us?","Nganong dili mo man nuon mi duawon?", 2);
        PhraseRepository.create(context,"I don't want to go to school.","Dili ko moeskuyla.", 2);
        PhraseRepository.create(context,"Thank you","Salamat", 2);
        PhraseRepository.create(context,"You're Welcome","Walay sapayan", 2);
        PhraseRepository.create(context,"The new store opens next week.","Sunod semana moabri ang bag-ong tindahan.", 2);
        PhraseRepository.create(context,"I don't want to wait that long.","Dili ko gustog ing ana kadugayg pinaabot.", 2);
        PhraseRepository.create(context,"I woke up at five this morning.","Alas singko sa buntag ko mibangon.", 2);
        PhraseRepository.create(context,"I'll call you when I get there.","Tawgan ta ka inig abot nako didto.", 2);
        PhraseRepository.create(context,"The bus driver opened the door.","Gibuksan sa drayber sa bus ang lukob.", 2);
        PhraseRepository.create(context,"He doesn't have to go to school.","Dili siya kinahanglang moadto sa tunghaan.", 2);
        PhraseRepository.create(context,"I don't know how to contact you.","Ambot unsaon ta ka pagpahibalo.", 2);
        PhraseRepository.create(context,"I don't know what to do anymore.","Wala na ko masayod unsa pay buhaton.", 2);
        PhraseRepository.create(context,"Forty-eight sailors are on board.","Nagsakay ang kap-atag walo ka tripulante.", 2);
        PhraseRepository.create(context,"Will you send up a bucket of ice?","Pagdala diri sa taas og usa ka baldeng hyelo.", 2);
        PhraseRepository.create(context,"Behave yourself during my absence.","Pagbinuotan baya samtang wala ko.", 2);
        PhraseRepository.create(context,"Does your girlfriend like flowers?","Ganahan ba og bulak ang imong uyab?", 2);
        PhraseRepository.create(context,"Does your girlfriend like flowers?","Ganahan ba og bulak ang imong nobya?", 2);
        PhraseRepository.create(context,"Tom didn't answer Mary's question.","Wala tubaga ni Tom ang pangutana ni Mary.", 2);
        PhraseRepository.create(context,"Unexpected results were announced.","Mga wala damhang linugdangan kadto toy gipahibalo.", 2);
        PhraseRepository.create(context,"Can you recommend a good restaurant?","May ikasugyot ka bang nindot nga kan-anan?", 2);
        PhraseRepository.create(context,"They added a woman to the committee.","Gidugangan nila og babaye ang komitiba.", 2);
        PhraseRepository.create(context,"He is content with his present state.","Igo na niya ang kasamtangang kahimtang.", 2);
        PhraseRepository.create(context,"Tom talked to Mary about the robbery.","Gisuginlan ni Tom si Mary bahin sa kawat.", 2);
        PhraseRepository.create(context,"Tom talked to Mary about the robbery.","Gisuginlan ni Tom si Mary bahin sa tulis.", 2);
        PhraseRepository.create(context,"Acid rain is not a natural phenomenon.","Dili kinaiyanhon ang makaluksaw nga ulan.", 2);
        PhraseRepository.create(context,"The hostages will be released tomorrow.","Ugma buhan ang mga gipakitaming.", 2);
        PhraseRepository.create(context,"The rocket is in orbit around the moon.","Milibotlibot ang kweti sa bulan.", 2);
        PhraseRepository.create(context,"I don't want any advertising on my website.","Dili ko gustong may adbertisment dinhi sa akong websayt.", 2);
        PhraseRepository.create(context,"It's better if I drove you all the way home.","Maayo pang ihatod ta lang hinuon ka ning kotse taman sa inyo.", 2);
        PhraseRepository.create(context,"Tom served 30 years for second degree murder.","Mialagad og 30 ka tuig si Tom alang sa ikaduhang degri sa pagpatay.", 2);
        PhraseRepository.create(context,"The crowd went wild when the news was announced.","Nagubot ang mga tawo dihang gibalita to.", 2);
        PhraseRepository.create(context,"Tom wanted Mary to know that he didn't hate her.","Buot ni Tom masayran ni Mary nga wala siya maitok niini.", 2);
        PhraseRepository.create(context,"Tom wanted Mary to know that he didn't hate her.","Buot ni Tom masayran ni Mary nga wala siyay kaitok niini.", 2);
        PhraseRepository.create(context,"Have you already carried the boxes up to the attic?","Gidala mo na ba ang mga kahon didto sa arkoba?", 2);
        PhraseRepository.create(context,"Burj Khalifa is currently the tallest skyscraper in the world.","Burj Khalifay kasamtangang kinahabogang dakbalay sa kalibotan.", 2);
        PhraseRepository.create(context,"Burj Khalifa is currently the tallest skyscraper in the world.","Burj Khalifa ang kasamtangang kinalayogang dakbalay sa tibuok kalibotan.", 2);
        PhraseRepository.create(context,"Martin Luther King Jr. fought for civil rights for African-Americans by teaching nonviolence.","Pinaagi sa pagtudlo sa pagka dili madinagmalon nakigbisog si Martin Luther King Jr. alang sa katungod nga sibil sa mga Amerkanong may dugong Afrikanhon.", 2);
    }


    public static void insertAllWords(Context context)
    {
        DB.getInstance(context).phraseDao().deleteAllWords();
        PhraseRepository.insertPharses(context);
    }

    public static Phrase pickWord(Context context, String word, int dialect)
    {
        return DB.getInstance(context).phraseDao().pickWordByDialect(word, dialect);
    }

    public static int availableWord(Context context, String word, int dialect)
    {
        return DB.getInstance(context).phraseDao().hasPickWord(word, dialect);
    }


}