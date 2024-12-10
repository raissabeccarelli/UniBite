/*
 * This file is generated by jOOQ.
 */
package classidb;


import com.example.jooq.generated.DefaultSchema;
import com.example.jooq.generated.Keys;

import recordclassidb.PiattiRecord;

import java.math.BigDecimal;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Piatti extends TableImpl<PiattiRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Piatti</code>
     */
    public static final Piatti PIATTI = new Piatti();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PiattiRecord> getRecordType() {
        return PiattiRecord.class;
    }

    /**
     * The column <code>Piatti.nome</code>.
     */
    public final TableField<PiattiRecord, String> NOME = createField(DSL.name("nome"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Piatti.descrizione</code>.
     */
    public final TableField<PiattiRecord, String> DESCRIZIONE = createField(DSL.name("descrizione"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>Piatti.ingredienti</code>.
     */
    public final TableField<PiattiRecord, String> INGREDIENTI = createField(DSL.name("ingredienti"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Piatti.allergeni</code>.
     */
    public final TableField<PiattiRecord, String> ALLERGENI = createField(DSL.name("allergeni"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>Piatti.tipoPortata</code>.
     */
    public final TableField<PiattiRecord, Integer> TIPOPORTATA = createField(DSL.name("tipoPortata"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>Piatti.prezzoUnitario</code>.
     */
    public final TableField<PiattiRecord, BigDecimal> PREZZOUNITARIO = createField(DSL.name("prezzoUnitario"), SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>Piatti.numeroPorzioni</code>.
     */
    public final TableField<PiattiRecord, Integer> NUMEROPORZIONI = createField(DSL.name("numeroPorzioni"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>Piatti.immagine</code>.
     */
    public final TableField<PiattiRecord, String> IMMAGINE = createField(DSL.name("immagine"), SQLDataType.CLOB, this, "");

    private Piatti(Name alias, Table<PiattiRecord> aliased) {
        this(alias, aliased, null);
    }

    private Piatti(Name alias, Table<PiattiRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Piatti</code> table reference
     */
    public Piatti(String alias) {
        this(DSL.name(alias), PIATTI);
    }

    /**
     * Create an aliased <code>Piatti</code> table reference
     */
    public Piatti(Name alias) {
        this(alias, PIATTI);
    }

    /**
     * Create a <code>Piatti</code> table reference
     */
    public Piatti() {
        this(DSL.name("Piatti"), null);
    }

    public <O extends Record> Piatti(Table<O> child, ForeignKey<O, PiattiRecord> key) {
        super(child, key, PIATTI);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey getPrimaryKey() {
        return Keys.PIATTI__PK_PIATTI;
    }

    @Override
    public Piatti as(String alias) {
        return new Piatti(DSL.name(alias), this);
    }

    @Override
    public Piatti as(Name alias) {
        return new Piatti(alias, this);
    }

    @Override
    public Piatti as(Table<?> alias) {
        return new Piatti(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Piatti rename(String name) {
        return new Piatti(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Piatti rename(Name name) {
        return new Piatti(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Piatti rename(Table<?> name) {
        return new Piatti(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, String, Integer, BigDecimal, Integer, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super String, ? super String, ? super String, ? super String, ? super Integer, ? super BigDecimal, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super String, ? super String, ? super String, ? super String, ? super Integer, ? super BigDecimal, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
