package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_ariasluque_agendainteractiva_models_NotesRealmProxy extends com.ariasluque.agendainteractiva.models.Notes
    implements RealmObjectProxy, com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface {

    static final class NotesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idNoteIndex;
        long titleNoteIndex;
        long contentNoteIndex;
        long textColorIndex;
        long noteColorIndex;
        long creationDateIndex;
        long urlImageIndex;

        NotesColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Notes");
            this.idNoteIndex = addColumnDetails("idNote", "idNote", objectSchemaInfo);
            this.titleNoteIndex = addColumnDetails("titleNote", "titleNote", objectSchemaInfo);
            this.contentNoteIndex = addColumnDetails("contentNote", "contentNote", objectSchemaInfo);
            this.textColorIndex = addColumnDetails("textColor", "textColor", objectSchemaInfo);
            this.noteColorIndex = addColumnDetails("noteColor", "noteColor", objectSchemaInfo);
            this.creationDateIndex = addColumnDetails("creationDate", "creationDate", objectSchemaInfo);
            this.urlImageIndex = addColumnDetails("urlImage", "urlImage", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        NotesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NotesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NotesColumnInfo src = (NotesColumnInfo) rawSrc;
            final NotesColumnInfo dst = (NotesColumnInfo) rawDst;
            dst.idNoteIndex = src.idNoteIndex;
            dst.titleNoteIndex = src.titleNoteIndex;
            dst.contentNoteIndex = src.contentNoteIndex;
            dst.textColorIndex = src.textColorIndex;
            dst.noteColorIndex = src.noteColorIndex;
            dst.creationDateIndex = src.creationDateIndex;
            dst.urlImageIndex = src.urlImageIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private NotesColumnInfo columnInfo;
    private ProxyState<com.ariasluque.agendainteractiva.models.Notes> proxyState;

    com_ariasluque_agendainteractiva_models_NotesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NotesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ariasluque.agendainteractiva.models.Notes>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$idNote() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idNoteIndex);
    }

    @Override
    public void realmSet$idNote(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'idNote' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$titleNote() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleNoteIndex);
    }

    @Override
    public void realmSet$titleNote(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'titleNote' to null.");
            }
            row.getTable().setString(columnInfo.titleNoteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'titleNote' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.titleNoteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$contentNote() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentNoteIndex);
    }

    @Override
    public void realmSet$contentNote(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentNoteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentNoteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentNoteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentNoteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$textColor() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.textColorIndex);
    }

    @Override
    public void realmSet$textColor(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.textColorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.textColorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$noteColor() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.noteColorIndex);
    }

    @Override
    public void realmSet$noteColor(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.noteColorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.noteColorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$creationDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.creationDateIndex);
    }

    @Override
    public void realmSet$creationDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'creationDate' to null.");
            }
            row.getTable().setString(columnInfo.creationDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'creationDate' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.creationDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$urlImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlImageIndex);
    }

    @Override
    public void realmSet$urlImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'urlImage' to null.");
            }
            row.getTable().setString(columnInfo.urlImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'urlImage' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.urlImageIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Notes", 7, 0);
        builder.addPersistedProperty("idNote", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("titleNote", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("contentNote", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("textColor", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("noteColor", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("creationDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("urlImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NotesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NotesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Notes";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Notes";
    }

    @SuppressWarnings("cast")
    public static com.ariasluque.agendainteractiva.models.Notes createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.ariasluque.agendainteractiva.models.Notes obj = null;
        if (update) {
            Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
            NotesColumnInfo columnInfo = (NotesColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class);
            long pkColumnIndex = columnInfo.idNoteIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("idNote")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("idNote"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("idNote")) {
                if (json.isNull("idNote")) {
                    obj = (io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy) realm.createObjectInternal(com.ariasluque.agendainteractiva.models.Notes.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy) realm.createObjectInternal(com.ariasluque.agendainteractiva.models.Notes.class, json.getInt("idNote"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'idNote'.");
            }
        }

        final com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface objProxy = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) obj;
        if (json.has("titleNote")) {
            if (json.isNull("titleNote")) {
                objProxy.realmSet$titleNote(null);
            } else {
                objProxy.realmSet$titleNote((String) json.getString("titleNote"));
            }
        }
        if (json.has("contentNote")) {
            if (json.isNull("contentNote")) {
                objProxy.realmSet$contentNote(null);
            } else {
                objProxy.realmSet$contentNote((String) json.getString("contentNote"));
            }
        }
        if (json.has("textColor")) {
            if (json.isNull("textColor")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'textColor' to null.");
            } else {
                objProxy.realmSet$textColor((int) json.getInt("textColor"));
            }
        }
        if (json.has("noteColor")) {
            if (json.isNull("noteColor")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'noteColor' to null.");
            } else {
                objProxy.realmSet$noteColor((int) json.getInt("noteColor"));
            }
        }
        if (json.has("creationDate")) {
            if (json.isNull("creationDate")) {
                objProxy.realmSet$creationDate(null);
            } else {
                objProxy.realmSet$creationDate((String) json.getString("creationDate"));
            }
        }
        if (json.has("urlImage")) {
            if (json.isNull("urlImage")) {
                objProxy.realmSet$urlImage(null);
            } else {
                objProxy.realmSet$urlImage((String) json.getString("urlImage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ariasluque.agendainteractiva.models.Notes createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ariasluque.agendainteractiva.models.Notes obj = new com.ariasluque.agendainteractiva.models.Notes();
        final com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface objProxy = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("idNote")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$idNote((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'idNote' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("titleNote")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$titleNote((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$titleNote(null);
                }
            } else if (name.equals("contentNote")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$contentNote((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$contentNote(null);
                }
            } else if (name.equals("textColor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$textColor((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'textColor' to null.");
                }
            } else if (name.equals("noteColor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$noteColor((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'noteColor' to null.");
                }
            } else if (name.equals("creationDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$creationDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$creationDate(null);
                }
            } else if (name.equals("urlImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$urlImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$urlImage(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'idNote'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_ariasluque_agendainteractiva_models_NotesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class), false, Collections.<String>emptyList());
        io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy obj = new io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.ariasluque.agendainteractiva.models.Notes copyOrUpdate(Realm realm, NotesColumnInfo columnInfo, com.ariasluque.agendainteractiva.models.Notes object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.ariasluque.agendainteractiva.models.Notes) cachedRealmObject;
        }

        com.ariasluque.agendainteractiva.models.Notes realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
            long pkColumnIndex = columnInfo.idNoteIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.ariasluque.agendainteractiva.models.Notes copy(Realm realm, NotesColumnInfo columnInfo, com.ariasluque.agendainteractiva.models.Notes newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ariasluque.agendainteractiva.models.Notes) cachedRealmObject;
        }

        com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface realmObjectSource = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idNoteIndex, realmObjectSource.realmGet$idNote());
        builder.addString(columnInfo.titleNoteIndex, realmObjectSource.realmGet$titleNote());
        builder.addString(columnInfo.contentNoteIndex, realmObjectSource.realmGet$contentNote());
        builder.addInteger(columnInfo.textColorIndex, realmObjectSource.realmGet$textColor());
        builder.addInteger(columnInfo.noteColorIndex, realmObjectSource.realmGet$noteColor());
        builder.addString(columnInfo.creationDateIndex, realmObjectSource.realmGet$creationDate());
        builder.addString(columnInfo.urlImageIndex, realmObjectSource.realmGet$urlImage());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_ariasluque_agendainteractiva_models_NotesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.ariasluque.agendainteractiva.models.Notes object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
        long tableNativePtr = table.getNativePtr();
        NotesColumnInfo columnInfo = (NotesColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class);
        long pkColumnIndex = columnInfo.idNoteIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$titleNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$titleNote();
        if (realmGet$titleNote != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleNoteIndex, rowIndex, realmGet$titleNote, false);
        }
        String realmGet$contentNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$contentNote();
        if (realmGet$contentNote != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentNoteIndex, rowIndex, realmGet$contentNote, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.textColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$textColor(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.noteColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$noteColor(), false);
        String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$creationDate();
        if (realmGet$creationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
        }
        String realmGet$urlImage = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$urlImage();
        if (realmGet$urlImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
        long tableNativePtr = table.getNativePtr();
        NotesColumnInfo columnInfo = (NotesColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class);
        long pkColumnIndex = columnInfo.idNoteIndex;
        com.ariasluque.agendainteractiva.models.Notes object = null;
        while (objects.hasNext()) {
            object = (com.ariasluque.agendainteractiva.models.Notes) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$titleNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$titleNote();
            if (realmGet$titleNote != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleNoteIndex, rowIndex, realmGet$titleNote, false);
            }
            String realmGet$contentNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$contentNote();
            if (realmGet$contentNote != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentNoteIndex, rowIndex, realmGet$contentNote, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.textColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$textColor(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.noteColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$noteColor(), false);
            String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$creationDate();
            if (realmGet$creationDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
            }
            String realmGet$urlImage = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$urlImage();
            if (realmGet$urlImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ariasluque.agendainteractiva.models.Notes object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
        long tableNativePtr = table.getNativePtr();
        NotesColumnInfo columnInfo = (NotesColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class);
        long pkColumnIndex = columnInfo.idNoteIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
        }
        cache.put(object, rowIndex);
        String realmGet$titleNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$titleNote();
        if (realmGet$titleNote != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleNoteIndex, rowIndex, realmGet$titleNote, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleNoteIndex, rowIndex, false);
        }
        String realmGet$contentNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$contentNote();
        if (realmGet$contentNote != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentNoteIndex, rowIndex, realmGet$contentNote, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentNoteIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.textColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$textColor(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.noteColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$noteColor(), false);
        String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$creationDate();
        if (realmGet$creationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.creationDateIndex, rowIndex, false);
        }
        String realmGet$urlImage = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$urlImage();
        if (realmGet$urlImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlImageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
        long tableNativePtr = table.getNativePtr();
        NotesColumnInfo columnInfo = (NotesColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Notes.class);
        long pkColumnIndex = columnInfo.idNoteIndex;
        com.ariasluque.agendainteractiva.models.Notes object = null;
        while (objects.hasNext()) {
            object = (com.ariasluque.agendainteractiva.models.Notes) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$idNote());
            }
            cache.put(object, rowIndex);
            String realmGet$titleNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$titleNote();
            if (realmGet$titleNote != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleNoteIndex, rowIndex, realmGet$titleNote, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleNoteIndex, rowIndex, false);
            }
            String realmGet$contentNote = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$contentNote();
            if (realmGet$contentNote != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentNoteIndex, rowIndex, realmGet$contentNote, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentNoteIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.textColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$textColor(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.noteColorIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$noteColor(), false);
            String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$creationDate();
            if (realmGet$creationDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.creationDateIndex, rowIndex, false);
            }
            String realmGet$urlImage = ((com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) object).realmGet$urlImage();
            if (realmGet$urlImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlImageIndex, rowIndex, realmGet$urlImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlImageIndex, rowIndex, false);
            }
        }
    }

    public static com.ariasluque.agendainteractiva.models.Notes createDetachedCopy(com.ariasluque.agendainteractiva.models.Notes realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ariasluque.agendainteractiva.models.Notes unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ariasluque.agendainteractiva.models.Notes();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ariasluque.agendainteractiva.models.Notes) cachedObject.object;
            }
            unmanagedObject = (com.ariasluque.agendainteractiva.models.Notes) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface unmanagedCopy = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) unmanagedObject;
        com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface realmSource = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$idNote(realmSource.realmGet$idNote());
        unmanagedCopy.realmSet$titleNote(realmSource.realmGet$titleNote());
        unmanagedCopy.realmSet$contentNote(realmSource.realmGet$contentNote());
        unmanagedCopy.realmSet$textColor(realmSource.realmGet$textColor());
        unmanagedCopy.realmSet$noteColor(realmSource.realmGet$noteColor());
        unmanagedCopy.realmSet$creationDate(realmSource.realmGet$creationDate());
        unmanagedCopy.realmSet$urlImage(realmSource.realmGet$urlImage());

        return unmanagedObject;
    }

    static com.ariasluque.agendainteractiva.models.Notes update(Realm realm, NotesColumnInfo columnInfo, com.ariasluque.agendainteractiva.models.Notes realmObject, com.ariasluque.agendainteractiva.models.Notes newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface realmObjectTarget = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) realmObject;
        com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface realmObjectSource = (com_ariasluque_agendainteractiva_models_NotesRealmProxyInterface) newObject;
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Notes.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idNoteIndex, realmObjectSource.realmGet$idNote());
        builder.addString(columnInfo.titleNoteIndex, realmObjectSource.realmGet$titleNote());
        builder.addString(columnInfo.contentNoteIndex, realmObjectSource.realmGet$contentNote());
        builder.addInteger(columnInfo.textColorIndex, realmObjectSource.realmGet$textColor());
        builder.addInteger(columnInfo.noteColorIndex, realmObjectSource.realmGet$noteColor());
        builder.addString(columnInfo.creationDateIndex, realmObjectSource.realmGet$creationDate());
        builder.addString(columnInfo.urlImageIndex, realmObjectSource.realmGet$urlImage());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Notes = proxy[");
        stringBuilder.append("{idNote:");
        stringBuilder.append(realmGet$idNote());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{titleNote:");
        stringBuilder.append(realmGet$titleNote());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contentNote:");
        stringBuilder.append(realmGet$contentNote() != null ? realmGet$contentNote() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{textColor:");
        stringBuilder.append(realmGet$textColor());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{noteColor:");
        stringBuilder.append(realmGet$noteColor());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{creationDate:");
        stringBuilder.append(realmGet$creationDate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{urlImage:");
        stringBuilder.append(realmGet$urlImage());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_ariasluque_agendainteractiva_models_NotesRealmProxy aNotes = (com_ariasluque_agendainteractiva_models_NotesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNotes.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNotes.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNotes.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
