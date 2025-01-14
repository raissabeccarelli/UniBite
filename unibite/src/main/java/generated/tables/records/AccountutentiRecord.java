/*
 * This file is generated by jOOQ.
 */
package generated.tables.records;


import generated.tables.Accountutenti;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountutentiRecord extends TableRecordImpl<AccountutentiRecord> implements Record7<Integer, String, String, String, String, Integer, BigDecimal> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>AccountUtenti.matricola</code>.
     */
    public void setMatricola(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>AccountUtenti.matricola</code>.
     */
    public Integer getMatricola() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>AccountUtenti.password</code>.
     */
    public void setPassword(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>AccountUtenti.password</code>.
     */
    public String getPassword() {
        return (String) get(1);
    }

    /**
     * Setter for <code>AccountUtenti.nome</code>.
     */
    public void setNome(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>AccountUtenti.nome</code>.
     */
    public String getNome() {
        return (String) get(2);
    }

    /**
     * Setter for <code>AccountUtenti.cognome</code>.
     */
    public void setCognome(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>AccountUtenti.cognome</code>.
     */
    public String getCognome() {
        return (String) get(3);
    }

    /**
     * Setter for <code>AccountUtenti.email</code>.
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>AccountUtenti.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>AccountUtenti.fasciaIsee</code>.
     */
    public void setFasciaisee(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>AccountUtenti.fasciaIsee</code>.
     */
    public Integer getFasciaisee() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>AccountUtenti.conto</code>.
     */
    public void setConto(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>AccountUtenti.conto</code>.
     */
    public BigDecimal getConto() {
        return (BigDecimal) get(6);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, Integer, BigDecimal> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, String, String, Integer, BigDecimal> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Accountutenti.ACCOUNTUTENTI.MATRICOLA;
    }

    @Override
    public Field<String> field2() {
        return Accountutenti.ACCOUNTUTENTI.PASSWORD;
    }

    @Override
    public Field<String> field3() {
        return Accountutenti.ACCOUNTUTENTI.NOME;
    }

    @Override
    public Field<String> field4() {
        return Accountutenti.ACCOUNTUTENTI.COGNOME;
    }

    @Override
    public Field<String> field5() {
        return Accountutenti.ACCOUNTUTENTI.EMAIL;
    }

    @Override
    public Field<Integer> field6() {
        return Accountutenti.ACCOUNTUTENTI.FASCIAISEE;
    }

    @Override
    public Field<BigDecimal> field7() {
        return Accountutenti.ACCOUNTUTENTI.CONTO;
    }

    @Override
    public Integer component1() {
        return getMatricola();
    }

    @Override
    public String component2() {
        return getPassword();
    }

    @Override
    public String component3() {
        return getNome();
    }

    @Override
    public String component4() {
        return getCognome();
    }

    @Override
    public String component5() {
        return getEmail();
    }

    @Override
    public Integer component6() {
        return getFasciaisee();
    }

    @Override
    public BigDecimal component7() {
        return getConto();
    }

    @Override
    public Integer value1() {
        return getMatricola();
    }

    @Override
    public String value2() {
        return getPassword();
    }

    @Override
    public String value3() {
        return getNome();
    }

    @Override
    public String value4() {
        return getCognome();
    }

    @Override
    public String value5() {
        return getEmail();
    }

    @Override
    public Integer value6() {
        return getFasciaisee();
    }

    @Override
    public BigDecimal value7() {
        return getConto();
    }

    @Override
    public AccountutentiRecord value1(Integer value) {
        setMatricola(value);
        return this;
    }

    @Override
    public AccountutentiRecord value2(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public AccountutentiRecord value3(String value) {
        setNome(value);
        return this;
    }

    @Override
    public AccountutentiRecord value4(String value) {
        setCognome(value);
        return this;
    }

    @Override
    public AccountutentiRecord value5(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public AccountutentiRecord value6(Integer value) {
        setFasciaisee(value);
        return this;
    }

    @Override
    public AccountutentiRecord value7(BigDecimal value) {
        setConto(value);
        return this;
    }

    @Override
    public AccountutentiRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6, BigDecimal value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountutentiRecord
     */
    public AccountutentiRecord() {
        super(Accountutenti.ACCOUNTUTENTI);
    }

    /**
     * Create a detached, initialised AccountutentiRecord
     */
    public AccountutentiRecord(Integer matricola, String password, String nome, String cognome, String email, Integer fasciaisee, BigDecimal conto) {
        super(Accountutenti.ACCOUNTUTENTI);

        setMatricola(matricola);
        setPassword(password);
        setNome(nome);
        setCognome(cognome);
        setEmail(email);
        setFasciaisee(fasciaisee);
        setConto(conto);
    }
}