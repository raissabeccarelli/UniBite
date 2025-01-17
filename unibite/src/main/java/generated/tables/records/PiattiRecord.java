/*
 * This file is generated by jOOQ.
 */
package generated.tables.records;


import generated.tables.Piatti;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PiattiRecord extends UpdatableRecordImpl<PiattiRecord> implements Record8<String, String, String, String, Integer, BigDecimal, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Piatti.nome</code>.
     */
    public void setNome(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>Piatti.nome</code>.
     */
    public String getNome() {
        return (String) get(0);
    }

    /**
     * Setter for <code>Piatti.descrizione</code>.
     */
    public void setDescrizione(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Piatti.descrizione</code>.
     */
    public String getDescrizione() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Piatti.ingredienti</code>.
     */
    public void setIngredienti(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Piatti.ingredienti</code>.
     */
    public String getIngredienti() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Piatti.allergeni</code>.
     */
    public void setAllergeni(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>Piatti.allergeni</code>.
     */
    public String getAllergeni() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Piatti.tipoPortata</code>.
     */
    public void setTipoportata(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>Piatti.tipoPortata</code>.
     */
    public Integer getTipoportata() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>Piatti.prezzoUnitario</code>.
     */
    public void setPrezzounitario(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>Piatti.prezzoUnitario</code>.
     */
    public BigDecimal getPrezzounitario() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>Piatti.immagine</code>.
     */
    public void setImmagine(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>Piatti.immagine</code>.
     */
    public String getImmagine() {
        return (String) get(6);
    }

    /**
     * Setter for <code>Piatti.numeroPorzioni</code>.
     */
    public void setNumeroporzioni(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>Piatti.numeroPorzioni</code>.
     */
    public Integer getNumeroporzioni() {
        return (Integer) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, String, Integer, BigDecimal, String, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<String, String, String, String, Integer, BigDecimal, String, Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Piatti.PIATTI.NOME;
    }

    @Override
    public Field<String> field2() {
        return Piatti.PIATTI.DESCRIZIONE;
    }

    @Override
    public Field<String> field3() {
        return Piatti.PIATTI.INGREDIENTI;
    }

    @Override
    public Field<String> field4() {
        return Piatti.PIATTI.ALLERGENI;
    }

    @Override
    public Field<Integer> field5() {
        return Piatti.PIATTI.TIPOPORTATA;
    }

    @Override
    public Field<BigDecimal> field6() {
        return Piatti.PIATTI.PREZZOUNITARIO;
    }

    @Override
    public Field<String> field7() {
        return Piatti.PIATTI.IMMAGINE;
    }

    @Override
    public Field<Integer> field8() {
        return Piatti.PIATTI.NUMEROPORZIONI;
    }

    @Override
    public String component1() {
        return getNome();
    }

    @Override
    public String component2() {
        return getDescrizione();
    }

    @Override
    public String component3() {
        return getIngredienti();
    }

    @Override
    public String component4() {
        return getAllergeni();
    }

    @Override
    public Integer component5() {
        return getTipoportata();
    }

    @Override
    public BigDecimal component6() {
        return getPrezzounitario();
    }

    @Override
    public String component7() {
        return getImmagine();
    }

    @Override
    public Integer component8() {
        return getNumeroporzioni();
    }

    @Override
    public String value1() {
        return getNome();
    }

    @Override
    public String value2() {
        return getDescrizione();
    }

    @Override
    public String value3() {
        return getIngredienti();
    }

    @Override
    public String value4() {
        return getAllergeni();
    }

    @Override
    public Integer value5() {
        return getTipoportata();
    }

    @Override
    public BigDecimal value6() {
        return getPrezzounitario();
    }

    @Override
    public String value7() {
        return getImmagine();
    }

    @Override
    public Integer value8() {
        return getNumeroporzioni();
    }

    @Override
    public PiattiRecord value1(String value) {
        setNome(value);
        return this;
    }

    @Override
    public PiattiRecord value2(String value) {
        setDescrizione(value);
        return this;
    }

    @Override
    public PiattiRecord value3(String value) {
        setIngredienti(value);
        return this;
    }

    @Override
    public PiattiRecord value4(String value) {
        setAllergeni(value);
        return this;
    }

    @Override
    public PiattiRecord value5(Integer value) {
        setTipoportata(value);
        return this;
    }

    @Override
    public PiattiRecord value6(BigDecimal value) {
        setPrezzounitario(value);
        return this;
    }

    @Override
    public PiattiRecord value7(String value) {
        setImmagine(value);
        return this;
    }

    @Override
    public PiattiRecord value8(Integer value) {
        setNumeroporzioni(value);
        return this;
    }

    @Override
    public PiattiRecord values(String value1, String value2, String value3, String value4, Integer value5, BigDecimal value6, String value7, Integer value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PiattiRecord
     */
    public PiattiRecord() {
        super(Piatti.PIATTI);
    }

    /**
     * Create a detached, initialised PiattiRecord
     */
    public PiattiRecord(String nome, String descrizione, String ingredienti, String allergeni, Integer tipoportata, BigDecimal prezzounitario, String immagine, Integer numeroporzioni) {
        super(Piatti.PIATTI);

        setNome(nome);
        setDescrizione(descrizione);
        setIngredienti(ingredienti);
        setAllergeni(allergeni);
        setTipoportata(tipoportata);
        setPrezzounitario(prezzounitario);
        setImmagine(immagine);
        setNumeroporzioni(numeroporzioni);
    }
}
