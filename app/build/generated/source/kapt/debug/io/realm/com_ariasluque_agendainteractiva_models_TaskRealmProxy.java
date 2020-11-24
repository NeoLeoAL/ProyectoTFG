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
public class com_ariasluque_agendainteractiva_models_TaskRealmProxy extends com.ariasluque.agendainteractiva.models.Task
    implements RealmObjectProxy, com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface {

    static final class TaskColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idTaskIndex;
        long titleTaskIndex;
        long creationDateIndex;
        long taskDoneIndex;

        TaskColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Task");
            this.idTaskIndex = addColumnDetails("idTask", "idTask", objectSchemaInfo);
            this.titleTaskIndex = addColumnDetails("titleTask", "titleTask", objectSchemaInfo);
            this.creationDateIndex = addColumnDetails("creationDate", "creationDate", objectSchemaInfo);
            this.taskDoneIndex = addColumnDetails("taskDone", "taskDone", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        TaskColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TaskColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TaskColumnInfo src = (TaskColumnInfo) rawSrc;
            final TaskColumnInfo dst = (TaskColumnInfo) rawDst;
            dst.idTaskIndex = src.idTaskIndex;
            dst.titleTaskIndex = src.titleTaskIndex;
            dst.creationDateIndex = src.creationDateIndex;
            dst.taskDoneIndex = src.taskDoneIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TaskColumnInfo columnInfo;
    private ProxyState<com.ariasluque.agendainteractiva.models.Task> proxyState;

    com_ariasluque_agendainteractiva_models_TaskRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaskColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ariasluque.agendainteractiva.models.Task>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$idTask() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idTaskIndex);
    }

    @Override
    public void realmSet$idTask(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'idTask' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$titleTask() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleTaskIndex);
    }

    @Override
    public void realmSet$titleTask(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'titleTask' to null.");
            }
            row.getTable().setString(columnInfo.titleTaskIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'titleTask' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.titleTaskIndex, value);
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
    public boolean realmGet$taskDone() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.taskDoneIndex);
    }

    @Override
    public void realmSet$taskDone(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.taskDoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.taskDoneIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Task", 4, 0);
        builder.addPersistedProperty("idTask", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("titleTask", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("creationDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("taskDone", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TaskColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TaskColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Task";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Task";
    }

    @SuppressWarnings("cast")
    public static com.ariasluque.agendainteractiva.models.Task createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.ariasluque.agendainteractiva.models.Task obj = null;
        if (update) {
            Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
            TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class);
            long pkColumnIndex = columnInfo.idTaskIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("idTask")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("idTask"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("idTask")) {
                if (json.isNull("idTask")) {
                    obj = (io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy) realm.createObjectInternal(com.ariasluque.agendainteractiva.models.Task.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy) realm.createObjectInternal(com.ariasluque.agendainteractiva.models.Task.class, json.getLong("idTask"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'idTask'.");
            }
        }

        final com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface objProxy = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) obj;
        if (json.has("titleTask")) {
            if (json.isNull("titleTask")) {
                objProxy.realmSet$titleTask(null);
            } else {
                objProxy.realmSet$titleTask((String) json.getString("titleTask"));
            }
        }
        if (json.has("creationDate")) {
            if (json.isNull("creationDate")) {
                objProxy.realmSet$creationDate(null);
            } else {
                objProxy.realmSet$creationDate((String) json.getString("creationDate"));
            }
        }
        if (json.has("taskDone")) {
            if (json.isNull("taskDone")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'taskDone' to null.");
            } else {
                objProxy.realmSet$taskDone((boolean) json.getBoolean("taskDone"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ariasluque.agendainteractiva.models.Task createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ariasluque.agendainteractiva.models.Task obj = new com.ariasluque.agendainteractiva.models.Task();
        final com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface objProxy = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("idTask")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$idTask((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'idTask' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("titleTask")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$titleTask((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$titleTask(null);
                }
            } else if (name.equals("creationDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$creationDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$creationDate(null);
                }
            } else if (name.equals("taskDone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$taskDone((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'taskDone' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'idTask'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_ariasluque_agendainteractiva_models_TaskRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class), false, Collections.<String>emptyList());
        io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy obj = new io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.ariasluque.agendainteractiva.models.Task copyOrUpdate(Realm realm, TaskColumnInfo columnInfo, com.ariasluque.agendainteractiva.models.Task object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.ariasluque.agendainteractiva.models.Task) cachedRealmObject;
        }

        com.ariasluque.agendainteractiva.models.Task realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
            long pkColumnIndex = columnInfo.idTaskIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.ariasluque.agendainteractiva.models.Task copy(Realm realm, TaskColumnInfo columnInfo, com.ariasluque.agendainteractiva.models.Task newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ariasluque.agendainteractiva.models.Task) cachedRealmObject;
        }

        com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface realmObjectSource = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) newObject;

        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idTaskIndex, realmObjectSource.realmGet$idTask());
        builder.addString(columnInfo.titleTaskIndex, realmObjectSource.realmGet$titleTask());
        builder.addString(columnInfo.creationDateIndex, realmObjectSource.realmGet$creationDate());
        builder.addBoolean(columnInfo.taskDoneIndex, realmObjectSource.realmGet$taskDone());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_ariasluque_agendainteractiva_models_TaskRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.ariasluque.agendainteractiva.models.Task object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class);
        long pkColumnIndex = columnInfo.idTaskIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$titleTask = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$titleTask();
        if (realmGet$titleTask != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleTaskIndex, rowIndex, realmGet$titleTask, false);
        }
        String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$creationDate();
        if (realmGet$creationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.taskDoneIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$taskDone(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class);
        long pkColumnIndex = columnInfo.idTaskIndex;
        com.ariasluque.agendainteractiva.models.Task object = null;
        while (objects.hasNext()) {
            object = (com.ariasluque.agendainteractiva.models.Task) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$titleTask = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$titleTask();
            if (realmGet$titleTask != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleTaskIndex, rowIndex, realmGet$titleTask, false);
            }
            String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$creationDate();
            if (realmGet$creationDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.taskDoneIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$taskDone(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.ariasluque.agendainteractiva.models.Task object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class);
        long pkColumnIndex = columnInfo.idTaskIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
        }
        cache.put(object, rowIndex);
        String realmGet$titleTask = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$titleTask();
        if (realmGet$titleTask != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleTaskIndex, rowIndex, realmGet$titleTask, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleTaskIndex, rowIndex, false);
        }
        String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$creationDate();
        if (realmGet$creationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.creationDateIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.taskDoneIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$taskDone(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(com.ariasluque.agendainteractiva.models.Task.class);
        long pkColumnIndex = columnInfo.idTaskIndex;
        com.ariasluque.agendainteractiva.models.Task object = null;
        while (objects.hasNext()) {
            object = (com.ariasluque.agendainteractiva.models.Task) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$idTask());
            }
            cache.put(object, rowIndex);
            String realmGet$titleTask = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$titleTask();
            if (realmGet$titleTask != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleTaskIndex, rowIndex, realmGet$titleTask, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleTaskIndex, rowIndex, false);
            }
            String realmGet$creationDate = ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$creationDate();
            if (realmGet$creationDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.creationDateIndex, rowIndex, realmGet$creationDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.creationDateIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.taskDoneIndex, rowIndex, ((com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) object).realmGet$taskDone(), false);
        }
    }

    public static com.ariasluque.agendainteractiva.models.Task createDetachedCopy(com.ariasluque.agendainteractiva.models.Task realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ariasluque.agendainteractiva.models.Task unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ariasluque.agendainteractiva.models.Task();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ariasluque.agendainteractiva.models.Task) cachedObject.object;
            }
            unmanagedObject = (com.ariasluque.agendainteractiva.models.Task) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface unmanagedCopy = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) unmanagedObject;
        com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface realmSource = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$idTask(realmSource.realmGet$idTask());
        unmanagedCopy.realmSet$titleTask(realmSource.realmGet$titleTask());
        unmanagedCopy.realmSet$creationDate(realmSource.realmGet$creationDate());
        unmanagedCopy.realmSet$taskDone(realmSource.realmGet$taskDone());

        return unmanagedObject;
    }

    static com.ariasluque.agendainteractiva.models.Task update(Realm realm, TaskColumnInfo columnInfo, com.ariasluque.agendainteractiva.models.Task realmObject, com.ariasluque.agendainteractiva.models.Task newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface realmObjectTarget = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) realmObject;
        com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface realmObjectSource = (com_ariasluque_agendainteractiva_models_TaskRealmProxyInterface) newObject;
        Table table = realm.getTable(com.ariasluque.agendainteractiva.models.Task.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idTaskIndex, realmObjectSource.realmGet$idTask());
        builder.addString(columnInfo.titleTaskIndex, realmObjectSource.realmGet$titleTask());
        builder.addString(columnInfo.creationDateIndex, realmObjectSource.realmGet$creationDate());
        builder.addBoolean(columnInfo.taskDoneIndex, realmObjectSource.realmGet$taskDone());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Task = proxy[");
        stringBuilder.append("{idTask:");
        stringBuilder.append(realmGet$idTask());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{titleTask:");
        stringBuilder.append(realmGet$titleTask());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{creationDate:");
        stringBuilder.append(realmGet$creationDate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{taskDone:");
        stringBuilder.append(realmGet$taskDone());
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
        com_ariasluque_agendainteractiva_models_TaskRealmProxy aTask = (com_ariasluque_agendainteractiva_models_TaskRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTask.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTask.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTask.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
