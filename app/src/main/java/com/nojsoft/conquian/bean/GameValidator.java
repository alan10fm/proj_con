package com.nojsoft.conquian.bean;

import android.view.ViewGroup;

import com.nojsoft.conquian.constants.CardConstants;
import com.nojsoft.conquian.views.CardView;
import com.nojsoft.conquian.views.GroupView;

import java.security.acl.Group;

/**
 * Created by jorge on 09/03/16.
 */
public class GameValidator {

    public static boolean validateGroup (GroupView group){
        boolean isValid = false;
        String flag = "sn";
        CardView currentCard;
        CardView previousCard;
        if (group.getChildCount() <= 1){
            group.setGameType(CardConstants.GameType.NONE);
            return true;//first card so it's correct no matter what
        }

        if (group.getChildCount() == 2){
            //Define type of group and set it to the flag
            currentCard = (CardView) group.getChildAt(1);
            previousCard = (CardView) group.getChildAt(0);
            if (currentCard.getNumValue() == previousCard.getNumValue()) {
                group.setGameType(CardConstants.GameType.SAME_KIND);
                return true;
            }
            if (currentCard.getType().equals(previousCard.getType())) {
                if ( Math.abs( currentCard.getNumValue() - currentCard.getNumValue()) == 1) {
                    group.setGameType(CardConstants.GameType.STRAIGHT);
                    return true;
                }
            }
        }

        if (group.getChildCount() > 2) {
            currentCard = (CardView) group.getChildAt(group.getChildCount()-1);
            previousCard = (CardView) group.getChildAt(group.getChildCount()-2);
            if (flag.equals(group.getGameType() == CardConstants.GameType.SAME_KIND)){
                if (currentCard.getNumValue() == previousCard.getNumValue()) {
                    // Set cards as one group
                    return true;
                }
            } else {
                if (currentCard.getType().equals(previousCard.getType())) {
                    if ( Math.abs( currentCard.getNumValue() - currentCard.getNumValue()) == 1) {
                        // set cards as same group
                        return true;
                    }
                }
            }
        }

        return isValid;
    }

    public static boolean validateGame (Table table){
        boolean isValid = false;

        return isValid;
    }

}