package com.gmail.pazuzu.creator;

import com.gmail.pazuzu.data.Address;
import com.gmail.pazuzu.makequestion.IMakeQuestion;
import com.gmail.pazuzu.makequestion.QuestionsConstantsData;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class AddressCreator

        // что такое Class can be a record?
{

    private final QuestionUtil utilsForQuestions;

    private final IMakeQuestion<Boolean> questionYesOrNot;

    public Set<Address> createAddresses()
    {
        Set<Address> addresses = new HashSet<>();
        do
        {
            addresses.add(createAddress());
        } while (questionYesOrNot.makeQuestion(QuestionsConstantsData.newAddress));
        return addresses;
    }

    private Address createAddress()
    {
        return new Address(utilsForQuestions.country(), utilsForQuestions.city(), utilsForQuestions.street(), utilsForQuestions.house(), utilsForQuestions.apartment());
    }
}
