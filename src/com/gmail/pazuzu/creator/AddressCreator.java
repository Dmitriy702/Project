package com.gmail.pazuzu.creator;

import com.gmail.pazuzu.data.Address;
import com.gmail.pazuzu.makequestion.AskYesOrNot;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import com.gmail.pazuzu.util.KeyboardLine;

import java.util.HashSet;

public class AddressCreator
{
    // Давай к общему интерфейсу приведешь
    private final HashSet<Address> addresses;

    private final CreatorsUtil utils;

    // ты че, не видишь что идея жёлтым подсвечивает?)
    private final IMakeQuestion questionYesOrNot;

    // название переменной не соотносится с ее функциональностью
    private final QuestionsConstantsData info;

    public AddressCreator()
    {
        addresses = new HashSet<>();
        info = new QuestionsConstantsData();
        questionYesOrNot = new AskYesOrNot(new KeyboardLine());
        utils = new CreatorsUtil();
    }

    public HashSet<Address> createAddresses()
    {
        do
        {
            addresses.add(createAddress());
        } while ((boolean) questionYesOrNot.makeQuestion(info.newAddress));
        return addresses;
    }

    // читая здесь utils не понятно о какой utils идет речь.
    private Address createAddress()
    {
        return new Address(utils.country(), utils.city(), utils.street(), utils.house(), utils.apartment());
    }
}
