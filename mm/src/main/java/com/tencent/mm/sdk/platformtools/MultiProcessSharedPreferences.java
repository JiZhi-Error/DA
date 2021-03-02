package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Deprecated
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    private static final int APPLY = 8;
    private static String AUTHORITY = null;
    private static volatile Uri AUTHORITY_URI = null;
    private static final int COMMIT = 9;
    private static final int CONTAINS = 7;
    public static final boolean DEBUG = false;
    private static final int GET_ALL = 1;
    private static final int GET_BOOLEAN = 6;
    private static final int GET_FLOAT = 5;
    private static final int GET_INT = 3;
    private static final int GET_LONG = 4;
    private static final int GET_STRING = 2;
    private static final String KEY = "value";
    private static final String KEY_NAME = "name";
    private static final String PATH_APPLY = "apply";
    private static final String PATH_COMMIT = "commit";
    private static final String PATH_CONTAINS = "contains";
    private static final String PATH_GET_ALL = "getAll";
    private static final String PATH_GET_BOOLEAN = "getBoolean";
    private static final String PATH_GET_FLOAT = "getFloat";
    private static final String PATH_GET_INT = "getInt";
    private static final String PATH_GET_LONG = "getLong";
    private static final String PATH_GET_STRING = "getString";
    private static final String PATH_REGISTER_ON_SHARED_PREFERENCE_CHANGE_LISTENER = "registerOnSharedPreferenceChangeListener";
    private static final String PATH_UNREGISTER_ON_SHARED_PREFERENCE_CHANGE_LISTENER = "unregisterOnSharedPreferenceChangeListener";
    private static final String PATH_WILDCARD = "*/";
    private static final int REGISTER_ON_SHARED_PREFERENCE_CHANGE_LISTENER = 10;
    private static final String TAG = "MicroMsg.MultiProcessSharedPreferences";
    private static final int UNREGISTER_ON_SHARED_PREFERENCE_CHANGE_LISTENER = 11;
    private Context mContext;
    private boolean mIsSafeMode;
    private List<SoftReference<SharedPreferences.OnSharedPreferenceChangeListener>> mListeners;
    private Map<String, Integer> mListenersCount;
    private int mMode;
    private String mName;
    private BroadcastReceiver mReceiver;
    private UriMatcher mUriMatcher;

    static /* synthetic */ void access$400(MultiProcessSharedPreferences multiProcessSharedPreferences, Context context) {
        AppMethodBeat.i(156347);
        multiProcessSharedPreferences.checkInitAuthority(context);
        AppMethodBeat.o(156347);
    }

    /* access modifiers changed from: package-private */
    public static class ReflectionUtil {
        private ReflectionUtil() {
        }

        public static ContentValues contentValuesNewInstance(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(156318);
            try {
                Constructor declaredConstructor = ContentValues.class.getDeclaredConstructor(HashMap.class);
                declaredConstructor.setAccessible(true);
                ContentValues contentValues = (ContentValues) declaredConstructor.newInstance(hashMap);
                AppMethodBeat.o(156318);
                return contentValues;
            } catch (IllegalArgumentException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(156318);
                throw runtimeException;
            } catch (IllegalAccessException e3) {
                RuntimeException runtimeException2 = new RuntimeException(e3);
                AppMethodBeat.o(156318);
                throw runtimeException2;
            } catch (InvocationTargetException e4) {
                RuntimeException runtimeException3 = new RuntimeException(e4);
                AppMethodBeat.o(156318);
                throw runtimeException3;
            } catch (NoSuchMethodException e5) {
                RuntimeException runtimeException4 = new RuntimeException(e5);
                AppMethodBeat.o(156318);
                throw runtimeException4;
            } catch (InstantiationException e6) {
                RuntimeException runtimeException5 = new RuntimeException(e6);
                AppMethodBeat.o(156318);
                throw runtimeException5;
            }
        }

        public static SharedPreferences.Editor editorPutStringSet(SharedPreferences.Editor editor, String str, Set<String> set) {
            AppMethodBeat.i(156319);
            try {
                SharedPreferences.Editor editor2 = (SharedPreferences.Editor) editor.getClass().getDeclaredMethod("putStringSet", String.class, Set.class).invoke(editor, str, set);
                AppMethodBeat.o(156319);
                return editor2;
            } catch (IllegalArgumentException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(156319);
                throw runtimeException;
            } catch (IllegalAccessException e3) {
                RuntimeException runtimeException2 = new RuntimeException(e3);
                AppMethodBeat.o(156319);
                throw runtimeException2;
            } catch (InvocationTargetException e4) {
                RuntimeException runtimeException3 = new RuntimeException(e4);
                AppMethodBeat.o(156319);
                throw runtimeException3;
            } catch (NoSuchMethodException e5) {
                RuntimeException runtimeException4 = new RuntimeException(e5);
                AppMethodBeat.o(156319);
                throw runtimeException4;
            }
        }

        public static void editorApply(SharedPreferences.Editor editor) {
            AppMethodBeat.i(215430);
            try {
                editor.getClass().getDeclaredMethod(MultiProcessSharedPreferences.PATH_APPLY, new Class[0]).invoke(editor, new Object[0]);
                AppMethodBeat.o(215430);
            } catch (IllegalArgumentException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(215430);
                throw runtimeException;
            } catch (IllegalAccessException e3) {
                RuntimeException runtimeException2 = new RuntimeException(e3);
                AppMethodBeat.o(215430);
                throw runtimeException2;
            } catch (InvocationTargetException e4) {
                RuntimeException runtimeException3 = new RuntimeException(e4);
                AppMethodBeat.o(215430);
                throw runtimeException3;
            } catch (NoSuchMethodException e5) {
                RuntimeException runtimeException4 = new RuntimeException(e5);
                AppMethodBeat.o(215430);
                throw runtimeException4;
            }
        }
    }

    private void checkInitAuthority(Context context) {
        AppMethodBeat.i(156320);
        if (AUTHORITY_URI == null) {
            String str = null;
            Uri uri = AUTHORITY_URI;
            synchronized (this) {
                if (uri == null) {
                    try {
                        str = queryAuthority(context);
                        if (str == null) {
                            str = context.getPackageName() + ".sdk.platformtools.MultiProcessSharedPreferences";
                        }
                        uri = Uri.parse("content://".concat(String.valueOf(str)));
                    } catch (Throwable th) {
                        AppMethodBeat.o(156320);
                        throw th;
                    }
                }
                if (str == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("'AUTHORITY' initialize failed.");
                    AppMethodBeat.o(156320);
                    throw illegalArgumentException;
                }
            }
            AUTHORITY = str;
            AUTHORITY_URI = uri;
        }
        AppMethodBeat.o(156320);
    }

    private static String queryAuthority(Context context) {
        PackageInfo packageInfo;
        AppMethodBeat.i(156321);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
        } catch (PackageManager.NameNotFoundException e2) {
            packageInfo = null;
        }
        if (!(packageInfo == null || packageInfo.providers == null)) {
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo.name.equals(MultiProcessSharedPreferences.class.getName())) {
                    String str = providerInfo.authority;
                    AppMethodBeat.o(156321);
                    return str;
                }
            }
        }
        AppMethodBeat.o(156321);
        return null;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i2) {
        AppMethodBeat.i(156322);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(str);
        MultiProcessMMKV.transport2MMKV(new MultiProcessSharedPreferences(context, str, i2), mmkv);
        AppMethodBeat.o(156322);
        return mmkv;
    }

    public MultiProcessSharedPreferences() {
    }

    private MultiProcessSharedPreferences(Context context, String str, int i2) {
        AppMethodBeat.i(156323);
        this.mContext = context;
        this.mName = str;
        this.mMode = i2;
        this.mIsSafeMode = context.getPackageManager().isSafeMode();
        AppMethodBeat.o(156323);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        AppMethodBeat.i(156324);
        Map<String, ?> map = (Map) getValue(PATH_GET_ALL, null, null);
        AppMethodBeat.o(156324);
        return map;
    }

    public String getString(String str, String str2) {
        AppMethodBeat.i(156325);
        String str3 = (String) getValue(PATH_GET_STRING, str, str2);
        if (str3 != null) {
            AppMethodBeat.o(156325);
            return str3;
        }
        AppMethodBeat.o(156325);
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        AppMethodBeat.i(156326);
        synchronized (this) {
            try {
                set2 = (Set) getValue(PATH_GET_STRING, str, set);
                if (set2 == null) {
                    set2 = set;
                }
            } finally {
                AppMethodBeat.o(156326);
            }
        }
        return set2;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(156327);
        Integer num = (Integer) getValue(PATH_GET_INT, str, Integer.valueOf(i2));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(156327);
            return intValue;
        }
        AppMethodBeat.o(156327);
        return i2;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(156328);
        Long l = (Long) getValue(PATH_GET_LONG, str, Long.valueOf(j2));
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(156328);
            return longValue;
        }
        AppMethodBeat.o(156328);
        return j2;
    }

    public float getFloat(String str, float f2) {
        AppMethodBeat.i(156329);
        Float f3 = (Float) getValue(PATH_GET_FLOAT, str, Float.valueOf(f2));
        if (f3 != null) {
            float floatValue = f3.floatValue();
            AppMethodBeat.o(156329);
            return floatValue;
        }
        AppMethodBeat.o(156329);
        return f2;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(156330);
        Boolean bool = (Boolean) getValue(PATH_GET_BOOLEAN, str, Boolean.valueOf(z));
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(156330);
            return booleanValue;
        }
        AppMethodBeat.o(156330);
        return z;
    }

    public boolean contains(String str) {
        AppMethodBeat.i(156331);
        Boolean bool = (Boolean) getValue(PATH_CONTAINS, str, null);
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(156331);
            return booleanValue;
        }
        AppMethodBeat.o(156331);
        return false;
    }

    public SharedPreferences.Editor edit() {
        AppMethodBeat.i(156332);
        EditorImpl editorImpl = new EditorImpl();
        AppMethodBeat.o(156332);
        return editorImpl;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(156333);
        synchronized (this) {
            try {
                if (this.mListeners == null) {
                    this.mListeners = new ArrayList();
                }
                Boolean bool = (Boolean) getValue(PATH_REGISTER_ON_SHARED_PREFERENCE_CHANGE_LISTENER, null, Boolean.FALSE);
                if (bool != null && bool.booleanValue()) {
                    this.mListeners.add(new SoftReference<>(onSharedPreferenceChangeListener));
                    if (this.mReceiver == null) {
                        this.mReceiver = new BroadcastReceiver() {
                            /* class com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.AnonymousClass1 */

                            public void onReceive(Context context, Intent intent) {
                                List list;
                                AppMethodBeat.i(156305);
                                String stringExtra = intent.getStringExtra("name");
                                List list2 = (List) intent.getSerializableExtra("value");
                                if (MultiProcessSharedPreferences.this.mName.equals(stringExtra) && list2 != null) {
                                    synchronized (MultiProcessSharedPreferences.this) {
                                        try {
                                            list = MultiProcessSharedPreferences.this.mListeners;
                                        } finally {
                                            AppMethodBeat.o(156305);
                                        }
                                    }
                                    ArrayList<SoftReference> arrayList = new ArrayList(list);
                                    for (int size = list2.size() - 1; size >= 0; size--) {
                                        String str = (String) list2.get(size);
                                        for (SoftReference softReference : arrayList) {
                                            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) softReference.get();
                                            if (onSharedPreferenceChangeListener != null) {
                                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(MultiProcessSharedPreferences.this, str);
                                            }
                                        }
                                    }
                                }
                            }
                        };
                        this.mContext.registerReceiver(this.mReceiver, new IntentFilter(makeAction(this.mName)));
                    }
                }
            } finally {
                AppMethodBeat.o(156333);
            }
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(156334);
        synchronized (this) {
            try {
                getValue(PATH_UNREGISTER_ON_SHARED_PREFERENCE_CHANGE_LISTENER, null, Boolean.FALSE);
                if (this.mListeners != null) {
                    ArrayList<SoftReference> arrayList = new ArrayList();
                    for (SoftReference<SharedPreferences.OnSharedPreferenceChangeListener> softReference : this.mListeners) {
                        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = softReference.get();
                        if (onSharedPreferenceChangeListener2 != null && onSharedPreferenceChangeListener2.equals(onSharedPreferenceChangeListener)) {
                            arrayList.add(softReference);
                        }
                    }
                    for (SoftReference softReference2 : arrayList) {
                        this.mListeners.remove(softReference2);
                    }
                    if (this.mListeners.isEmpty() && this.mReceiver != null) {
                        this.mContext.unregisterReceiver(this.mReceiver);
                        this.mReceiver = null;
                        this.mListeners = null;
                    }
                }
            } finally {
                AppMethodBeat.o(156334);
            }
        }
    }

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear = false;
        private final Map<String, Object> mModified = new HashMap();

        public EditorImpl() {
            AppMethodBeat.i(156307);
            AppMethodBeat.o(156307);
        }

        public final SharedPreferences.Editor putString(String str, String str2) {
            AppMethodBeat.i(156308);
            synchronized (this) {
                try {
                    this.mModified.put(str, str2);
                } finally {
                    AppMethodBeat.o(156308);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.i(156309);
            synchronized (this) {
                try {
                    this.mModified.put(str, set == null ? null : new HashSet(set));
                } finally {
                    AppMethodBeat.o(156309);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putInt(String str, int i2) {
            AppMethodBeat.i(156310);
            synchronized (this) {
                try {
                    this.mModified.put(str, Integer.valueOf(i2));
                } finally {
                    AppMethodBeat.o(156310);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putLong(String str, long j2) {
            AppMethodBeat.i(156311);
            synchronized (this) {
                try {
                    this.mModified.put(str, Long.valueOf(j2));
                } finally {
                    AppMethodBeat.o(156311);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putFloat(String str, float f2) {
            AppMethodBeat.i(156312);
            synchronized (this) {
                try {
                    this.mModified.put(str, Float.valueOf(f2));
                } finally {
                    AppMethodBeat.o(156312);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(156313);
            synchronized (this) {
                try {
                    this.mModified.put(str, Boolean.valueOf(z));
                } finally {
                    AppMethodBeat.o(156313);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor remove(String str) {
            AppMethodBeat.i(156314);
            synchronized (this) {
                try {
                    this.mModified.put(str, null);
                } finally {
                    AppMethodBeat.o(156314);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        public final void apply() {
            AppMethodBeat.i(156315);
            setValue(MultiProcessSharedPreferences.PATH_APPLY);
            AppMethodBeat.o(156315);
        }

        public final boolean commit() {
            AppMethodBeat.i(156316);
            boolean value = setValue(MultiProcessSharedPreferences.PATH_COMMIT);
            AppMethodBeat.o(156316);
            return value;
        }

        private boolean setValue(String str) {
            boolean z;
            AppMethodBeat.i(156317);
            if (MultiProcessSharedPreferences.this.mIsSafeMode) {
                AppMethodBeat.o(156317);
                return false;
            }
            synchronized (MultiProcessSharedPreferences.this) {
                try {
                    MultiProcessSharedPreferences.access$400(MultiProcessSharedPreferences.this, MultiProcessSharedPreferences.this.mContext);
                    String[] strArr = {String.valueOf(MultiProcessSharedPreferences.this.mMode), String.valueOf(this.mClear)};
                    synchronized (this) {
                        try {
                            z = MultiProcessSharedPreferences.this.mContext.getContentResolver().update(Uri.withAppendedPath(Uri.withAppendedPath(MultiProcessSharedPreferences.AUTHORITY_URI, MultiProcessSharedPreferences.this.mName), str), ReflectionUtil.contentValuesNewInstance((HashMap) this.mModified), null, strArr) > 0;
                        } catch (Throwable th) {
                            AppMethodBeat.o(156317);
                            throw th;
                        }
                    }
                } finally {
                    AppMethodBeat.o(156317);
                }
            }
            return z;
        }
    }

    private Object getValue(String str, String str2, Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(156335);
        if (this.mIsSafeMode) {
            AppMethodBeat.o(156335);
            return null;
        }
        checkInitAuthority(this.mContext);
        Uri withAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), str);
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(this.mMode);
        strArr[1] = str2;
        strArr[2] = obj == null ? null : String.valueOf(obj);
        Cursor query = this.mContext.getContentResolver().query(withAppendedPath, null, null, strArr, null);
        if (query != null) {
            try {
                Bundle extras = query.getExtras();
                if (extras != null) {
                    obj2 = extras.get("value");
                    extras.clear();
                }
            } catch (Exception e2) {
            }
            query.close();
        }
        if (obj2 != null) {
            AppMethodBeat.o(156335);
            return obj2;
        }
        AppMethodBeat.o(156335);
        return obj;
    }

    private String makeAction(String str) {
        AppMethodBeat.i(156336);
        String format = String.format("%1$s_%2$s", MultiProcessSharedPreferences.class.getName(), str);
        AppMethodBeat.o(156336);
        return format;
    }

    public boolean onCreate() {
        AppMethodBeat.i(156337);
        checkInitAuthority(getContext());
        this.mUriMatcher = new UriMatcher(-1);
        this.mUriMatcher.addURI(AUTHORITY, "*/getAll", 1);
        this.mUriMatcher.addURI(AUTHORITY, "*/getString", 2);
        this.mUriMatcher.addURI(AUTHORITY, "*/getInt", 3);
        this.mUriMatcher.addURI(AUTHORITY, "*/getLong", 4);
        this.mUriMatcher.addURI(AUTHORITY, "*/getFloat", 5);
        this.mUriMatcher.addURI(AUTHORITY, "*/getBoolean", 6);
        this.mUriMatcher.addURI(AUTHORITY, "*/contains", 7);
        this.mUriMatcher.addURI(AUTHORITY, "*/apply", 8);
        this.mUriMatcher.addURI(AUTHORITY, "*/commit", 9);
        this.mUriMatcher.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
        this.mUriMatcher.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
        AppMethodBeat.o(156337);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(156338);
        String str3 = uri.getPathSegments().get(0);
        int parseInt = Integer.parseInt(strArr2[0]);
        String str4 = strArr2[1];
        String str5 = strArr2[2];
        Bundle bundle = new Bundle();
        switch (this.mUriMatcher.match(uri)) {
            case 1:
                bundle.putSerializable("value", (HashMap) getContext().getSharedPreferences(str3, parseInt).getAll());
                break;
            case 2:
                bundle.putString("value", getContext().getSharedPreferences(str3, parseInt).getString(str4, str5));
                break;
            case 3:
                bundle.putInt("value", getContext().getSharedPreferences(str3, parseInt).getInt(str4, Integer.parseInt(str5)));
                break;
            case 4:
                bundle.putLong("value", getContext().getSharedPreferences(str3, parseInt).getLong(str4, Long.parseLong(str5)));
                break;
            case 5:
                bundle.putFloat("value", getContext().getSharedPreferences(str3, parseInt).getFloat(str4, Float.parseFloat(str5)));
                break;
            case 6:
                bundle.putBoolean("value", getContext().getSharedPreferences(str3, parseInt).getBoolean(str4, Boolean.parseBoolean(str5)));
                break;
            case 7:
                bundle.putBoolean("value", getContext().getSharedPreferences(str3, parseInt).contains(str4));
                break;
            case 8:
            case 9:
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This is Unknown Uri：".concat(String.valueOf(uri)));
                AppMethodBeat.o(156338);
                throw illegalArgumentException;
            case 10:
                checkInitListenersCount();
                Integer num = this.mListenersCount.get(str3);
                int intValue = (num == null ? 0 : num.intValue()) + 1;
                this.mListenersCount.put(str3, Integer.valueOf(intValue));
                Integer num2 = this.mListenersCount.get(str3);
                bundle.putBoolean("value", intValue == (num2 == null ? 0 : num2.intValue()));
                break;
            case 11:
                checkInitListenersCount();
                Integer num3 = this.mListenersCount.get(str3);
                int intValue2 = (num3 == null ? 0 : num3.intValue()) - 1;
                if (intValue2 > 0) {
                    this.mListenersCount.put(str3, Integer.valueOf(intValue2));
                    Integer num4 = this.mListenersCount.get(str3);
                    bundle.putBoolean("value", intValue2 == (num4 == null ? 0 : num4.intValue()));
                    break;
                } else {
                    this.mListenersCount.remove(str3);
                    bundle.putBoolean("value", !this.mListenersCount.containsKey(str3));
                    break;
                }
        }
        BundleCursor bundleCursor = new BundleCursor(bundle);
        AppMethodBeat.o(156338);
        return bundleCursor;
    }

    public String getType(Uri uri) {
        AppMethodBeat.i(156339);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external call");
        AppMethodBeat.o(156339);
        throw unsupportedOperationException;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(156340);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external insert");
        AppMethodBeat.o(156340);
        throw unsupportedOperationException;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(156341);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external delete");
        AppMethodBeat.o(156341);
        throw unsupportedOperationException;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        HashMap hashMap;
        ArrayList<String> arrayList;
        int i2;
        AppMethodBeat.i(156342);
        String str2 = uri.getPathSegments().get(0);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(str2, Integer.parseInt(strArr[0]));
        int match = this.mUriMatcher.match(uri);
        switch (match) {
            case 8:
            case 9:
                boolean z = this.mListenersCount != null && this.mListenersCount.get(str2) != null && this.mListenersCount.get(str2).intValue() > 0;
                HashMap hashMap2 = new HashMap();
                if (z) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    hashMap = sharedPreferences.getAll();
                    arrayList = arrayList2;
                } else {
                    hashMap = hashMap2;
                    arrayList = null;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (Boolean.parseBoolean(strArr[1])) {
                    if (z && hashMap != null && !hashMap.isEmpty()) {
                        for (Map.Entry<String, ?> entry : hashMap.entrySet()) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    edit.clear();
                }
                for (Map.Entry<String, Object> entry2 : contentValues.valueSet()) {
                    String key = entry2.getKey();
                    Object value = entry2.getValue();
                    if ((value instanceof EditorImpl) || value == null) {
                        edit.remove(key);
                        if (z && hashMap != null && hashMap.containsKey(key)) {
                            arrayList.add(key);
                        }
                    } else if (z && hashMap != null && (!hashMap.containsKey(key) || (hashMap.containsKey(key) && !value.equals(hashMap.get(key))))) {
                        arrayList.add(key);
                    }
                    if (value instanceof String) {
                        edit.putString(key, (String) value);
                    } else if (value instanceof Set) {
                        ReflectionUtil.editorPutStringSet(edit, key, (Set) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(key, ((Boolean) value).booleanValue());
                    }
                }
                if (!z || !arrayList.isEmpty()) {
                    switch (match) {
                        case 8:
                            ReflectionUtil.editorApply(edit);
                            notifyListeners(str2, arrayList);
                            i2 = 1;
                            break;
                        case 9:
                            if (edit.commit()) {
                                notifyListeners(str2, arrayList);
                                i2 = 1;
                                break;
                            }
                        default:
                            i2 = 0;
                            break;
                    }
                } else {
                    i2 = 1;
                }
                contentValues.clear();
                AppMethodBeat.o(156342);
                return i2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This is Unknown Uri：".concat(String.valueOf(uri)));
                AppMethodBeat.o(156342);
                throw illegalArgumentException;
        }
    }

    public void onLowMemory() {
        AppMethodBeat.i(156343);
        if (this.mListenersCount != null) {
            this.mListenersCount.clear();
        }
        super.onLowMemory();
        AppMethodBeat.o(156343);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(156344);
        if (this.mListenersCount != null) {
            this.mListenersCount.clear();
        }
        super.onTrimMemory(i2);
        AppMethodBeat.o(156344);
    }

    private void checkInitListenersCount() {
        AppMethodBeat.i(156345);
        if (this.mListenersCount == null) {
            this.mListenersCount = new HashMap();
        }
        AppMethodBeat.o(156345);
    }

    private void notifyListeners(String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(156346);
        if (arrayList != null && !arrayList.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction(makeAction(str));
            intent.setPackage(getContext().getPackageName());
            intent.putExtra("name", str);
            intent.putExtra("value", arrayList);
            getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(156346);
    }

    static final class BundleCursor extends MatrixCursor {
        private Bundle mBundle;

        public BundleCursor(Bundle bundle) {
            super(new String[0], 0);
            AppMethodBeat.i(156306);
            this.mBundle = bundle;
            AppMethodBeat.o(156306);
        }

        public final Bundle getExtras() {
            return this.mBundle;
        }

        public final Bundle respond(Bundle bundle) {
            this.mBundle = bundle;
            return this.mBundle;
        }
    }
}
