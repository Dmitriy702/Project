package com.gmail.pazuzu;

import com.gmail.pazuzu.creator.AddressCreator;
import com.gmail.pazuzu.creator.ContactCreator;
import com.gmail.pazuzu.creator.PersonCreator;
import com.gmail.pazuzu.creator.QuestionUtil;
import com.gmail.pazuzu.data.PeopleData;
import com.gmail.pazuzu.data.Person;
import com.gmail.pazuzu.enums.Sex;
import com.gmail.pazuzu.makequestion.AskQuestionAboutDate;
import com.gmail.pazuzu.makequestion.AskQuestionAboutSex;
import com.gmail.pazuzu.makequestion.AskTextQuestion;
import com.gmail.pazuzu.makequestion.AskYesOrNot;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.service.AgeStatistic;
import com.gmail.pazuzu.service.ArmyStatistic;
import com.gmail.pazuzu.service.Demonstrator;
import com.gmail.pazuzu.service.Menu;
import com.gmail.pazuzu.service.PeopleManager;
import com.gmail.pazuzu.service.Searcher;
import com.gmail.pazuzu.service.SexStatistic;
import com.gmail.pazuzu.service.Statistic;
import com.gmail.pazuzu.util.DateUtil;
import com.gmail.pazuzu.util.KeyboardString;

import java.time.LocalDate;
import java.util.Set;

public class Starter
{
    private static final KeyboardString string = KeyboardString.getInstance();
    private static final Set<Person> people = PeopleData.getInstance().getPeopleData();
    private static final DateUtil ageUtil = new DateUtil();
    private static final IMakeQuestion<Boolean> yesNoQuestion = new AskYesOrNot(string);
    private static final IMakeQuestion<String> textQuestion = new AskTextQuestion(string);
    private static final IMakeQuestion<Sex> sexQuestion = new AskQuestionAboutSex(string);
    private static final IMakeQuestion<LocalDate> dateQuestion = new AskQuestionAboutDate(string, ageUtil);
    private static final QuestionUtil utilsForQuestions = new QuestionUtil(textQuestion, dateQuestion, sexQuestion);
    private static final AddressCreator addressCreator = new AddressCreator(utilsForQuestions, yesNoQuestion);
    private static final ContactCreator contactCreator = new ContactCreator(utilsForQuestions);
    private static final PersonCreator personCreator = new PersonCreator(ageUtil, utilsForQuestions, addressCreator, contactCreator);
    private static final Searcher searcherText = new Searcher(people, textQuestion);
    private static final PeopleManager peoplesManager = new PeopleManager(yesNoQuestion, personCreator, searcherText);
    private static final Demonstrator demonstrator = new Demonstrator(searcherText, people);
    private static final Statistic sexStatistic = new SexStatistic(people);
    private static final Statistic ageStatistic = new AgeStatistic(people);
    private static final Statistic armyStatistic = new ArmyStatistic(people);
    private static final Menu menu = new Menu(peoplesManager, demonstrator, string, sexStatistic, ageStatistic, armyStatistic);

    public static void main(String[] args)
    {
        menu.showMenu();
    }
}
