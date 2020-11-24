package com.ariasluque.agendainteractiva.controller

import io.realm.DynamicRealm
import io.realm.FieldAttribute
import io.realm.RealmMigration

// Clase para migrar la clase Task a la BD de Realm
class CustomRealmMigration : RealmMigration {
    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        var oldVersion = oldVersion
        val schema = realm.schema

        if (oldVersion == 0L) {

            schema.create("Task")
                .addField("idTask", Long::class.javaPrimitiveType, FieldAttribute.PRIMARY_KEY)
                .addField("titleTask", Int::class.javaPrimitiveType)
                .addField("creationDate", String::class.java)
                .addField("taskDone", Boolean::class.java)

            oldVersion++
        }
    }

    override fun hashCode(): Int {
        return CustomRealmMigration::class.java.hashCode()
    }

    override fun equals(`object`: Any?): Boolean {
        return if (`object` == null) {
            false
        } else `object` is CustomRealmMigration
    }
}