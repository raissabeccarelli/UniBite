/*
 * This file is generated by jOOQ.
 */
package com.example.jooq.generated;


import com.example.jooq.generated.tables.Accountpersonale;
import com.example.jooq.generated.tables.Accountutenti;
import com.example.jooq.generated.tables.Piatti;
import com.example.jooq.generated.tables.records.AccountpersonaleRecord;
import com.example.jooq.generated.tables.records.AccountutentiRecord;
import com.example.jooq.generated.tables.records.PiattiRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountpersonaleRecord> ACCOUNTPERSONALE__PK_ACCOUNTPERSONALE = Internal.createUniqueKey(Accountpersonale.ACCOUNTPERSONALE, DSL.name("pk_AccountPersonale"), new TableField[] { Accountpersonale.ACCOUNTPERSONALE.USERNAME }, true);
    public static final UniqueKey<AccountutentiRecord> ACCOUNTUTENTI__UK_ACCOUNTUTENTI_43808232 = Internal.createUniqueKey(Accountutenti.ACCOUNTUTENTI, DSL.name("uk_AccountUtenti_43808232"), new TableField[] { Accountutenti.ACCOUNTUTENTI.MATRICOLA, Accountutenti.ACCOUNTUTENTI.EMAIL }, true);
    public static final UniqueKey<PiattiRecord> PIATTI__PK_PIATTI = Internal.createUniqueKey(Piatti.PIATTI, DSL.name("pk_Piatti"), new TableField[] { Piatti.PIATTI.NOME }, true);
}
