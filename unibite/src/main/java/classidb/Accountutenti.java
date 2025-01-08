/*
 * This file is generated by jOOQ.
 */
package classidb;


import exampleGenerati.DefaultSchema;
import exampleGenerati.Keys;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import classiRecords.AccountutentiRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Accountutenti extends TableImpl<AccountutentiRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>AccountUtenti</code>
     */
    public static final Accountutenti ACCOUNTUTENTI = new Accountutenti();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountutentiRecord> getRecordType() {
        return AccountutentiRecord.class;
    }

    /**
     * The column <code>AccountUtenti.matricola</code>.
     */
    public final TableField<AccountutentiRecord, Integer> MATRICOLA = createField(DSL.name("matricola"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>AccountUtenti.password</code>.
     */
    public final TableField<AccountutentiRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>AccountUtenti.nome</code>.
     */
    public final TableField<AccountutentiRecord, String> NOME = createField(DSL.name("nome"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>AccountUtenti.cognome</code>.
     */
    public final TableField<AccountutentiRecord, String> COGNOME = createField(DSL.name("cognome"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>AccountUtenti.email</code>.
     */
    public final TableField<AccountutentiRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>AccountUtenti.fasciaIsee</code>.
     */
    public final TableField<AccountutentiRecord, Integer> FASCIAISEE = createField(DSL.name("fasciaIsee"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field(DSL.raw("7"), SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>AccountUtenti.conto</code>.
     */
    public final TableField<AccountutentiRecord, BigDecimal> CONTO = createField(DSL.name("conto"), SQLDataType.NUMERIC.nullable(false).defaultValue(DSL.field(DSL.raw("0"), SQLDataType.NUMERIC)), this, "");

    private Accountutenti(Name alias, Table<AccountutentiRecord> aliased) {
        this(alias, aliased, null);
    }

    private Accountutenti(Name alias, Table<AccountutentiRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>AccountUtenti</code> table reference
     */
    public Accountutenti(String alias) {
        this(DSL.name(alias), ACCOUNTUTENTI);
    }

    /**
     * Create an aliased <code>AccountUtenti</code> table reference
     */
    public Accountutenti(Name alias) {
        this(alias, ACCOUNTUTENTI);
    }

    /**
     * Create a <code>AccountUtenti</code> table reference
     */
    public Accountutenti() {
        this(DSL.name("AccountUtenti"), null);
    }

    public <O extends Record> Accountutenti(Table<O> child, ForeignKey<O, AccountutentiRecord> key) {
        super(child, key, ACCOUNTUTENTI);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<UniqueKey<AccountutentiRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.ACCOUNTUTENTI__UK_ACCOUNTUTENTI_43808232);
    }

    @Override
    public Accountutenti as(String alias) {
        return new Accountutenti(DSL.name(alias), this);
    }

    @Override
    public Accountutenti as(Name alias) {
        return new Accountutenti(alias, this);
    }

    @Override
    public Accountutenti as(Table<?> alias) {
        return new Accountutenti(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Accountutenti rename(String name) {
        return new Accountutenti(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Accountutenti rename(Name name) {
        return new Accountutenti(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Accountutenti rename(Table<?> name) {
        return new Accountutenti(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, Integer, BigDecimal> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super Integer, ? super String, ? super String, ? super String, ? super String, ? super Integer, ? super BigDecimal, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super Integer, ? super String, ? super String, ? super String, ? super String, ? super Integer, ? super BigDecimal, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}