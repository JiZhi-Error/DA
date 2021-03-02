package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.LruCache;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParserException;

@Deprecated
public class MultiProcSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.MultiProcSharedPreferences";
    private static final Object mContent = new Object();
    private static MMHandler mMainThreadHandler = null;
    private static final LruCache<String, MultiProcSharedPreferences> mSPCache = new LruCache<>(5);
    private File mBackupFile = null;
    private int mDiskWritesInFlight = 0;
    private File mFile = null;
    private FLock mFileLock = null;
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<>();
    private boolean mLoaded = false;
    private Map<String, Object> mMap = null;
    private int mMode = 0;
    private boolean mShouldLockFile = false;
    private long mStatSize = 0;
    private long mStatTimestamp = 0;
    private final Object mWritingToDiskLock = new Object();

    static /* synthetic */ void access$000(MultiProcSharedPreferences multiProcSharedPreferences) {
        AppMethodBeat.i(156247);
        multiProcSharedPreferences.loadFromDiskLocked();
        AppMethodBeat.o(156247);
    }

    static /* synthetic */ int access$308(MultiProcSharedPreferences multiProcSharedPreferences) {
        int i2 = multiProcSharedPreferences.mDiskWritesInFlight;
        multiProcSharedPreferences.mDiskWritesInFlight = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$310(MultiProcSharedPreferences multiProcSharedPreferences) {
        int i2 = multiProcSharedPreferences.mDiskWritesInFlight;
        multiProcSharedPreferences.mDiskWritesInFlight = i2 - 1;
        return i2;
    }

    static /* synthetic */ void access$900(File file, int i2) {
        AppMethodBeat.i(156248);
        setFilePermissionsFromMode(file, i2);
        AppMethodBeat.o(156248);
    }

    static {
        AppMethodBeat.i(156249);
        AppMethodBeat.o(156249);
    }

    public static class DynamicConfigStorage {
        public static String PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY = "pref_key_is_disabled_MultiProcSP_manually";
        public static String PREF_KEY_IS_ENABLE_MULTIPROC_SP = "pref_key_is_enable_MultiProcSP";
        private static final String PREF_NAME = "pref_MultiProcSP_dyncfg";
        private static SharedPreferences mPref = MMApplicationContext.getContext().getSharedPreferences(PREF_NAME, 4);

        static {
            AppMethodBeat.i(156208);
            AppMethodBeat.o(156208);
        }

        public static void setDisabledFlagManually(boolean z) {
            AppMethodBeat.i(156203);
            setValue(PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY, z);
            AppMethodBeat.o(156203);
        }

        private static boolean isDisabledManually() {
            AppMethodBeat.i(215388);
            boolean value = getValue(PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY, false);
            AppMethodBeat.o(215388);
            return value;
        }

        public static boolean isEnabledMultiProcSP() {
            AppMethodBeat.i(156204);
            if (isDisabledManually() || !getValue(PREF_KEY_IS_ENABLE_MULTIPROC_SP, false)) {
                AppMethodBeat.o(156204);
                return false;
            }
            AppMethodBeat.o(156204);
            return true;
        }

        private static void reload() {
            AppMethodBeat.i(156205);
            mPref = MMApplicationContext.getContext().getSharedPreferences(PREF_NAME, 4);
            AppMethodBeat.o(156205);
        }

        private static boolean getValue(String str, boolean z) {
            AppMethodBeat.i(215389);
            reload();
            if (mPref == null) {
                Log.w(MultiProcSharedPreferences.TAG, "SharedPreferences in DynamicConfigStorage initialize failed.");
                AppMethodBeat.o(215389);
                return z;
            }
            boolean z2 = mPref.getBoolean(str, z);
            Log.d(MultiProcSharedPreferences.TAG, "DynamicConfigStorage, getValue:%b", Boolean.valueOf(z2));
            AppMethodBeat.o(215389);
            return z2;
        }

        public static void setValue(String str, boolean z) {
            AppMethodBeat.i(156207);
            if (mPref == null) {
                Log.w(MultiProcSharedPreferences.TAG, "SharedPreferences in DynamicConfigStorage initialize failed.");
                AppMethodBeat.o(156207);
                return;
            }
            SharedPreferences.Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
            AppMethodBeat.o(156207);
        }
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i2, boolean z) {
        AppMethodBeat.i(215391);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(str);
        if (DynamicConfigStorage.isEnabledMultiProcSP()) {
            Log.i(TAG, "sp: %s, use Flock version MultiProcessSP.", str);
            MultiProcSharedPreferences multiProcSharedPreferences = mSPCache.get(str);
            if (multiProcSharedPreferences == null) {
                multiProcSharedPreferences = new MultiProcSharedPreferences(context, str, i2);
                mSPCache.put(str, multiProcSharedPreferences);
            } else if ((i2 & 4) != 0) {
                if (z) {
                    multiProcSharedPreferences.startLoadFromDisk();
                } else {
                    multiProcSharedPreferences.startReloadIfChangedUnexpectedly();
                }
            }
            MultiProcessMMKV.transport2MMKV(multiProcSharedPreferences, mmkv);
            AppMethodBeat.o(215391);
            return mmkv;
        }
        Log.i(TAG, "sp: %s, use system sp.", str);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i2);
        AppMethodBeat.o(215391);
        return sharedPreferences;
    }

    private MultiProcSharedPreferences() {
        AppMethodBeat.i(156232);
        RuntimeException runtimeException = new RuntimeException("Not supported.");
        AppMethodBeat.o(156232);
        throw runtimeException;
    }

    private MultiProcSharedPreferences(Context context, String str, int i2) {
        boolean z = false;
        AppMethodBeat.i(156233);
        Context applicationContext = context.getApplicationContext();
        if (mMainThreadHandler == null) {
            mMainThreadHandler = new MMHandler(Looper.getMainLooper());
        }
        this.mFile = new File(getSharedPrefsDir(applicationContext), str + ".xml");
        this.mBackupFile = makeBackupFile(this.mFile);
        this.mMode = i2;
        this.mShouldLockFile = (i2 & 4) != 0 ? true : z;
        if (this.mShouldLockFile) {
            this.mFileLock = new FLock(this.mFile.getPath() + ".lock", true);
        }
        startLoadFromDisk();
        AppMethodBeat.o(156233);
    }

    @SuppressLint({"SdCardPath"})
    private File getSharedPrefsDir(Context context) {
        AppMethodBeat.i(215392);
        String str = context.getApplicationInfo().dataDir;
        if (str == null || str.length() == 0) {
            Log.w(TAG, "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            str = "/data/data/" + context.getPackageName();
        }
        Log.i(TAG, "Path to store sp data: ".concat(String.valueOf(str)));
        File file = new File(str, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.canRead() || !file.canWrite()) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        AppMethodBeat.o(215392);
        return file;
    }

    private File makeBackupFile(File file) {
        AppMethodBeat.i(215393);
        File file2 = new File(file.getPath() + ".bak");
        AppMethodBeat.o(215393);
        return file2;
    }

    private void startLoadFromDisk() {
        AppMethodBeat.i(156234);
        synchronized (this) {
            try {
                this.mLoaded = false;
            } catch (Throwable th) {
                AppMethodBeat.o(156234);
                throw th;
            }
        }
        h.RTc.ba(new Runnable() {
            /* class com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(156202);
                synchronized (MultiProcSharedPreferences.this) {
                    try {
                        MultiProcSharedPreferences.access$000(MultiProcSharedPreferences.this);
                    } finally {
                        AppMethodBeat.o(156202);
                    }
                }
            }
        });
        AppMethodBeat.o(156234);
    }

    private void loadFromDiskLocked() {
        boolean z;
        AppMethodBeat.i(215394);
        if (this.mShouldLockFile) {
            try {
                this.mFileLock.lockRead();
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        try {
            if (this.mLoaded) {
                if (z) {
                    try {
                        return;
                    } catch (Exception e3) {
                    }
                }
                return;
            }
            if (this.mBackupFile.exists()) {
                this.mFile.delete();
                this.mBackupFile.renameTo(this.mFile);
            }
            if (this.mFile.exists() && !this.mFile.canRead()) {
                Log.w(TAG, "Attempt to read preferences file " + this.mFile + " without permission");
            }
            HashMap<String, Object> hashMap = null;
            if (this.mFile.canRead()) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.mFile), 16384);
                    hashMap = XmlUtils.readMapXml(bufferedInputStream);
                    bufferedInputStream.close();
                } catch (XmlPullParserException e4) {
                    Log.w(TAG, "getSharedPreferences", e4);
                } catch (FileNotFoundException e5) {
                    Log.w(TAG, "getSharedPreferences", e5);
                } catch (IOException e6) {
                    Log.w(TAG, "getSharedPreferences", e6);
                }
            }
            this.mLoaded = true;
            if (hashMap != null) {
                this.mMap = hashMap;
                this.mStatTimestamp = this.mFile.lastModified();
                this.mStatSize = this.mFile.length();
            } else {
                this.mMap = new HashMap();
            }
            notifyAll();
            if (this.mShouldLockFile) {
                try {
                    this.mFileLock.unlock();
                    AppMethodBeat.o(215394);
                } catch (Exception e7) {
                    AppMethodBeat.o(215394);
                }
            } else {
                AppMethodBeat.o(215394);
            }
        } finally {
            if (this.mShouldLockFile) {
                try {
                    this.mFileLock.unlock();
                } catch (Exception e8) {
                }
            }
            AppMethodBeat.o(215394);
        }
    }

    public void startReloadIfChangedUnexpectedly() {
        AppMethodBeat.i(215395);
        synchronized (this) {
            try {
                if (hasFileChangedUnexpectedly()) {
                    startLoadFromDisk();
                    AppMethodBeat.o(215395);
                }
            } finally {
                AppMethodBeat.o(215395);
            }
        }
    }

    private boolean hasFileChangedUnexpectedly() {
        AppMethodBeat.i(215396);
        if (this.mDiskWritesInFlight > 0) {
            AppMethodBeat.o(215396);
            return false;
        } else if (this.mStatTimestamp == this.mFile.lastModified() && this.mStatSize == this.mFile.length()) {
            AppMethodBeat.o(215396);
            return false;
        } else {
            AppMethodBeat.o(215396);
            return true;
        }
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(156235);
        synchronized (this) {
            try {
                this.mListeners.put(onSharedPreferenceChangeListener, mContent);
            } finally {
                AppMethodBeat.o(156235);
            }
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        AppMethodBeat.i(156236);
        synchronized (this) {
            try {
                this.mListeners.remove(onSharedPreferenceChangeListener);
            } finally {
                AppMethodBeat.o(156236);
            }
        }
    }

    private void awaitLoadedLocked() {
        AppMethodBeat.i(156237);
        while (!this.mLoaded) {
            try {
                wait();
            } catch (InterruptedException e2) {
            }
        }
        AppMethodBeat.o(156237);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        AppMethodBeat.i(156238);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                hashMap = new HashMap(this.mMap);
            } finally {
                AppMethodBeat.o(156238);
            }
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        String str3;
        AppMethodBeat.i(156239);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                str3 = (String) this.mMap.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            } finally {
                AppMethodBeat.o(156239);
            }
        }
        return str3;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        AppMethodBeat.i(156240);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                set2 = (Set) this.mMap.get(str);
                if (set2 == null) {
                    set2 = set;
                }
            } finally {
                AppMethodBeat.o(156240);
            }
        }
        return set2;
    }

    public int getInt(String str, int i2) {
        AppMethodBeat.i(156241);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Integer num = (Integer) this.mMap.get(str);
                if (num != null) {
                    i2 = num.intValue();
                }
            } finally {
                AppMethodBeat.o(156241);
            }
        }
        return i2;
    }

    public long getLong(String str, long j2) {
        AppMethodBeat.i(156242);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Long l = (Long) this.mMap.get(str);
                if (l != null) {
                    j2 = l.longValue();
                }
            } finally {
                AppMethodBeat.o(156242);
            }
        }
        return j2;
    }

    public float getFloat(String str, float f2) {
        AppMethodBeat.i(156243);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Float f3 = (Float) this.mMap.get(str);
                if (f3 != null) {
                    f2 = f3.floatValue();
                }
            } finally {
                AppMethodBeat.o(156243);
            }
        }
        return f2;
    }

    public boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(156244);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                Boolean bool = (Boolean) this.mMap.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            } finally {
                AppMethodBeat.o(156244);
            }
        }
        return z;
    }

    public boolean contains(String str) {
        boolean containsKey;
        AppMethodBeat.i(156245);
        synchronized (this) {
            try {
                awaitLoadedLocked();
                containsKey = this.mMap.containsKey(str);
            } finally {
                AppMethodBeat.o(156245);
            }
        }
        return containsKey;
    }

    public SharedPreferences.Editor edit() {
        AppMethodBeat.i(156246);
        synchronized (this) {
            try {
                awaitLoadedLocked();
            } catch (Throwable th) {
                AppMethodBeat.o(156246);
                throw th;
            }
        }
        EditorImpl editorImpl = new EditorImpl();
        AppMethodBeat.o(156246);
        return editorImpl;
    }

    /* access modifiers changed from: package-private */
    public static class MemoryCommitResult {
        public boolean changesMade;
        public List<String> keysModified;
        public Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners;
        public Map<String, Object> mapToWriteToDisk;
        public volatile boolean writeToDiskResult;
        public final CountDownLatch writtenToDiskLatch;

        private MemoryCommitResult() {
            AppMethodBeat.i(156229);
            this.changesMade = false;
            this.keysModified = null;
            this.listeners = null;
            this.mapToWriteToDisk = null;
            this.writtenToDiskLatch = new CountDownLatch(1);
            this.writeToDiskResult = false;
            AppMethodBeat.o(156229);
        }

        public void setDiskWriteResult(boolean z) {
            AppMethodBeat.i(156230);
            this.writeToDiskResult = z;
            this.writtenToDiskLatch.countDown();
            AppMethodBeat.o(156230);
        }
    }

    final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private final Map<String, Object> mModified;

        private EditorImpl() {
            AppMethodBeat.i(156213);
            this.mModified = new HashMap();
            this.mClear = false;
            AppMethodBeat.o(156213);
        }

        static /* synthetic */ void access$1600(EditorImpl editorImpl, MemoryCommitResult memoryCommitResult) {
            AppMethodBeat.i(156228);
            editorImpl.notifyListeners(memoryCommitResult);
            AppMethodBeat.o(156228);
        }

        static /* synthetic */ void access$700(EditorImpl editorImpl, MemoryCommitResult memoryCommitResult) {
            AppMethodBeat.i(156227);
            editorImpl.writeToFile(memoryCommitResult);
            AppMethodBeat.o(156227);
        }

        public final SharedPreferences.Editor putString(String str, String str2) {
            AppMethodBeat.i(156214);
            synchronized (this) {
                try {
                    this.mModified.put(str, str2);
                } finally {
                    AppMethodBeat.o(156214);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            AppMethodBeat.i(156215);
            synchronized (this) {
                try {
                    this.mModified.put(str, set);
                } finally {
                    AppMethodBeat.o(156215);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putInt(String str, int i2) {
            AppMethodBeat.i(156216);
            synchronized (this) {
                try {
                    this.mModified.put(str, Integer.valueOf(i2));
                } finally {
                    AppMethodBeat.o(156216);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putLong(String str, long j2) {
            AppMethodBeat.i(156217);
            synchronized (this) {
                try {
                    this.mModified.put(str, Long.valueOf(j2));
                } finally {
                    AppMethodBeat.o(156217);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putFloat(String str, float f2) {
            AppMethodBeat.i(156218);
            synchronized (this) {
                try {
                    this.mModified.put(str, Float.valueOf(f2));
                } finally {
                    AppMethodBeat.o(156218);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            AppMethodBeat.i(156219);
            synchronized (this) {
                try {
                    this.mModified.put(str, Boolean.valueOf(z));
                } finally {
                    AppMethodBeat.o(156219);
                }
            }
            return this;
        }

        public final SharedPreferences.Editor remove(String str) {
            AppMethodBeat.i(156220);
            synchronized (this) {
                try {
                    this.mModified.put(str, this);
                } finally {
                    AppMethodBeat.o(156220);
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

        public final boolean commit() {
            AppMethodBeat.i(156221);
            MemoryCommitResult commitToMemory = commitToMemory();
            enqueueDiskWrite(commitToMemory, null);
            try {
                commitToMemory.writtenToDiskLatch.await();
                notifyListeners(commitToMemory);
                boolean z = commitToMemory.writeToDiskResult;
                AppMethodBeat.o(156221);
                return z;
            } catch (InterruptedException e2) {
                AppMethodBeat.o(156221);
                return false;
            }
        }

        public final void apply() {
            AppMethodBeat.i(156222);
            final MemoryCommitResult commitToMemory = commitToMemory();
            final AnonymousClass1 r1 = new Runnable() {
                /* class com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.EditorImpl.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(156209);
                    try {
                        commitToMemory.writtenToDiskLatch.await();
                        AppMethodBeat.o(156209);
                    } catch (InterruptedException e2) {
                        AppMethodBeat.o(156209);
                    }
                }
            };
            QueuedWork.add(r1);
            enqueueDiskWrite(commitToMemory, new Runnable() {
                /* class com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.EditorImpl.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(156210);
                    r1.run();
                    QueuedWork.remove(r1);
                    AppMethodBeat.o(156210);
                }
            });
            notifyListeners(commitToMemory);
            AppMethodBeat.o(156222);
        }

        private MemoryCommitResult commitToMemory() {
            Object obj;
            AppMethodBeat.i(156223);
            MemoryCommitResult memoryCommitResult = new MemoryCommitResult();
            synchronized (MultiProcSharedPreferences.this) {
                try {
                    if (MultiProcSharedPreferences.this.mDiskWritesInFlight > 0) {
                        MultiProcSharedPreferences.this.mMap = new HashMap(MultiProcSharedPreferences.this.mMap);
                    }
                    memoryCommitResult.mapToWriteToDisk = MultiProcSharedPreferences.this.mMap;
                    MultiProcSharedPreferences.access$308(MultiProcSharedPreferences.this);
                    boolean z = MultiProcSharedPreferences.this.mListeners.size() > 0;
                    if (z) {
                        memoryCommitResult.keysModified = new ArrayList();
                        memoryCommitResult.listeners = new HashSet(MultiProcSharedPreferences.this.mListeners.keySet());
                    }
                    synchronized (this) {
                        try {
                            if (this.mClear) {
                                if (!MultiProcSharedPreferences.this.mMap.isEmpty()) {
                                    memoryCommitResult.changesMade = true;
                                    MultiProcSharedPreferences.this.mMap.clear();
                                }
                                this.mClear = false;
                            }
                            for (Map.Entry<String, Object> entry : this.mModified.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value == this) {
                                    if (MultiProcSharedPreferences.this.mMap.containsKey(key)) {
                                        MultiProcSharedPreferences.this.mMap.remove(key);
                                    }
                                } else if (!MultiProcSharedPreferences.this.mMap.containsKey(key) || (obj = MultiProcSharedPreferences.this.mMap.get(key)) == null || !obj.equals(value)) {
                                    MultiProcSharedPreferences.this.mMap.put(key, value);
                                }
                                memoryCommitResult.changesMade = true;
                                if (z) {
                                    memoryCommitResult.keysModified.add(key);
                                }
                            }
                            this.mModified.clear();
                        } catch (Throwable th) {
                            AppMethodBeat.o(156223);
                            throw th;
                        }
                    }
                } finally {
                    AppMethodBeat.o(156223);
                }
            }
            return memoryCommitResult;
        }

        private void enqueueDiskWrite(final MemoryCommitResult memoryCommitResult, final Runnable runnable) {
            boolean z = true;
            AppMethodBeat.i(156224);
            AnonymousClass3 r3 = new Runnable() {
                /* class com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.EditorImpl.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(156211);
                    synchronized (MultiProcSharedPreferences.this.mWritingToDiskLock) {
                        try {
                            EditorImpl.access$700(EditorImpl.this, memoryCommitResult);
                        } finally {
                            AppMethodBeat.o(156211);
                        }
                    }
                    synchronized (MultiProcSharedPreferences.this) {
                        try {
                            MultiProcSharedPreferences.access$310(MultiProcSharedPreferences.this);
                        } finally {
                            AppMethodBeat.o(156211);
                        }
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            if (runnable == null) {
                synchronized (MultiProcSharedPreferences.this) {
                    try {
                        if (MultiProcSharedPreferences.this.mDiskWritesInFlight != 1) {
                            z = false;
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(156224);
                        throw th;
                    }
                }
                if (z) {
                    r3.run();
                    AppMethodBeat.o(156224);
                    return;
                }
            }
            QueuedWork.singleThreadExecutor().execute(r3);
            AppMethodBeat.o(156224);
        }

        private FileOutputStream createFileOutputStream(File file) {
            FileOutputStream fileOutputStream;
            AppMethodBeat.i(156225);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e2) {
                File parentFile = file.getParentFile();
                if (!parentFile.mkdir()) {
                    Log.e(MultiProcSharedPreferences.TAG, "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(file)));
                    AppMethodBeat.o(156225);
                    return null;
                }
                MultiProcSharedPreferences.access$900(parentFile, MultiProcSharedPreferences.this.mMode);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e3) {
                    Log.e(MultiProcSharedPreferences.TAG, "Couldn't create SharedPreferences file ".concat(String.valueOf(file)), e3);
                    fileOutputStream = null;
                }
            }
            AppMethodBeat.o(156225);
            return fileOutputStream;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
            if (r6.this$0.mBackupFile.exists() != false) goto L_0x00df;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r6.this$0.mFile.renameTo(r6.this$0.mBackupFile) != false) goto L_0x00e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            com.tencent.mm.sdk.platformtools.Log.e(com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.TAG, "Couldn't rename file " + r6.this$0.mFile + " to backup file " + r6.this$0.mBackupFile);
            r7.setDiskWriteResult(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ab, code lost:
            if (r6.this$0.mShouldLockFile == false) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r6.this$0.mFileLock.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b6, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(215390);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00da, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(215390);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00df, code lost:
            r6.this$0.mFile.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01ce A[SYNTHETIC, Splitter:B:80:0x01ce] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01f9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void writeToFile(com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.MemoryCommitResult r7) {
            /*
            // Method dump skipped, instructions count: 513
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.EditorImpl.writeToFile(com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences$MemoryCommitResult):void");
        }

        private void notifyListeners(final MemoryCommitResult memoryCommitResult) {
            AppMethodBeat.i(156226);
            if (memoryCommitResult.listeners == null || memoryCommitResult.keysModified == null || memoryCommitResult.keysModified.size() == 0) {
                AppMethodBeat.o(156226);
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                for (int size = memoryCommitResult.keysModified.size() - 1; size >= 0; size--) {
                    String str = memoryCommitResult.keysModified.get(size);
                    for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : memoryCommitResult.listeners) {
                        if (onSharedPreferenceChangeListener != null) {
                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(MultiProcSharedPreferences.this, str);
                        }
                    }
                }
                AppMethodBeat.o(156226);
            } else {
                MultiProcSharedPreferences.mMainThreadHandler.post(new Runnable() {
                    /* class com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.EditorImpl.AnonymousClass4 */

                    public void run() {
                        AppMethodBeat.i(156212);
                        EditorImpl.access$1600(EditorImpl.this, memoryCommitResult);
                        AppMethodBeat.o(156212);
                    }
                });
                AppMethodBeat.o(156226);
            }
        }
    }

    private static void setFilePermissionsFromMode(File file, int i2) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(215397);
        if ((i2 & 1) == 0) {
            z = true;
        } else {
            z = false;
        }
        file.setReadable(true, z);
        if ((i2 & 2) == 0) {
            z2 = true;
        }
        file.setWritable(true, z2);
        AppMethodBeat.o(215397);
    }
}
