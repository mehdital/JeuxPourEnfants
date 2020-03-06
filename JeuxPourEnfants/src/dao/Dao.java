/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionJDM.SQLConnection;
import entity.JeuxDeMots;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author stag
 * @param <Q>
 */
public interface Dao<Q> {

    Connection CONNECTION = SQLConnection.getInstanceWithProperties("MySQLInfos.properties");

// cree une fonction qui fasse un tirage aléatoire
    public abstract Q getQuestion();
    // public abstract Q getReponse();

    // methode create jeuxDeMots
    public abstract void create(Q obj);

    public abstract void update(Q obj);

    public abstract void delete(Q obj);

    public JeuxDeMots find(int id);

}
