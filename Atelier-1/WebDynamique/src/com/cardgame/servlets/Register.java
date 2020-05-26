package com.cardgame.servlets;

import com.cardgame.controler.CardDao;
import com.cardgame.model.CardModel;
import com.cardgame.utils.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher( Constants.REGISTER_VIEW ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        String name = request.getParameter( Constants.NAME_FIELD );
        String description = request.getParameter( Constants.DESCRIPTION_FIELD );
        String imageUrl = request.getParameter( Constants.IMAGE_URL_FIELD );
        String family = request.getParameter( Constants.FAMILY_FIELD );
        int hp = Integer.parseInt(request.getParameter( Constants.HP_FIELD ));
        int energy = Integer.parseInt(request.getParameter( Constants.ENERGY_FIELD ));
        int attack = Integer.parseInt(request.getParameter( Constants.ATTACK_FIELD ));
        int defence = Integer.parseInt(request.getParameter(Constants.DEFENCE_FIELD));

        // TODO: nous aurions effectué une vérification des données envoyées par le formulaire
        //  si nous avions été dans des conditions réelles

        CardModel card = new CardModel(name, description, family, hp, energy, defence, attack, imageUrl);
        boolean requestOk = true;
        try{
            CardDao.getInstance().addCard(card);
        }catch(Exception e){
            request.setAttribute(Constants.ATT_RESULTAT, "Erreur lors de l'ajout de la carte à la BDD.");
            request.setAttribute(Constants.ATT_CLASS, "erreur");
            requestOk = false;
        }
        if(requestOk) {
            request.setAttribute(Constants.ATT_RESULTAT, "Carte ajoutée avec succès.");
            request.setAttribute(Constants.ATT_CLASS, "succes");
        }

        this.getServletContext().getRequestDispatcher( Constants.REGISTER_VIEW ).forward( request, response );
    }
}