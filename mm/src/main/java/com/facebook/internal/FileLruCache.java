package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Limits limits;
    private final Object lock;
    private final String tag;

    /* access modifiers changed from: package-private */
    public interface StreamCloseCallback {
        void onClose();
    }

    static /* synthetic */ void access$100(FileLruCache fileLruCache, String str, File file) {
        AppMethodBeat.i(17802);
        fileLruCache.renameToTargetAndTrim(str, file);
        AppMethodBeat.o(17802);
    }

    static /* synthetic */ void access$200(FileLruCache fileLruCache) {
        AppMethodBeat.i(17803);
        fileLruCache.trim();
        AppMethodBeat.o(17803);
    }

    static {
        AppMethodBeat.i(17804);
        AppMethodBeat.o(17804);
    }

    public FileLruCache(String str, Limits limits2) {
        AppMethodBeat.i(17789);
        this.tag = str;
        this.limits = limits2;
        this.directory = new File(FacebookSdk.getCacheDir(), str);
        this.lock = new Object();
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            BufferFile.deleteAll(this.directory);
        }
        AppMethodBeat.o(17789);
    }

    /* access modifiers changed from: package-private */
    public final long sizeInBytesForTest() {
        AppMethodBeat.i(17790);
        synchronized (this.lock) {
            while (true) {
                try {
                    if (!(this.isTrimPending || this.isTrimInProgress)) {
                        break;
                    }
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e2) {
                    }
                } finally {
                    AppMethodBeat.o(17790);
                }
            }
        }
        File[] listFiles = this.directory.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            for (File file : listFiles) {
                j2 += file.length();
            }
        }
        return j2;
    }

    public final InputStream get(String str) {
        AppMethodBeat.i(17791);
        InputStream inputStream = get(str, null);
        AppMethodBeat.o(17791);
        return inputStream;
    }

    public final InputStream get(String str, String str2) {
        AppMethodBeat.i(17792);
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject readHeader = StreamHeader.readHeader(bufferedInputStream);
                if (readHeader == null) {
                    return null;
                }
                String optString = readHeader.optString("key");
                if (optString == null || !optString.equals(str)) {
                    bufferedInputStream.close();
                    AppMethodBeat.o(17792);
                    return null;
                }
                String optString2 = readHeader.optString(HEADER_CACHE_CONTENT_TAG_KEY, null);
                if ((str2 != null || optString2 == null) && (str2 == null || str2.equals(optString2))) {
                    long time = new Date().getTime();
                    Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    AppMethodBeat.o(17792);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                AppMethodBeat.o(17792);
                return null;
            } finally {
                bufferedInputStream.close();
                AppMethodBeat.o(17792);
            }
        } catch (IOException e2) {
            AppMethodBeat.o(17792);
            return null;
        }
    }

    public final OutputStream openPutStream(String str) {
        AppMethodBeat.i(17793);
        OutputStream openPutStream = openPutStream(str, null);
        AppMethodBeat.o(17793);
        return openPutStream;
    }

    public final OutputStream openPutStream(final String str, String str2) {
        AppMethodBeat.i(17794);
        final File newFile = BufferFile.newFile(this.directory);
        newFile.delete();
        if (!newFile.createNewFile()) {
            IOException iOException = new IOException("Could not create file at " + newFile.getAbsolutePath());
            AppMethodBeat.o(17794);
            throw iOException;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            final long currentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() {
                /* class com.facebook.internal.FileLruCache.AnonymousClass1 */

                @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                public void onClose() {
                    AppMethodBeat.i(17759);
                    if (currentTimeMillis < FileLruCache.this.lastClearCacheTime.get()) {
                        newFile.delete();
                        AppMethodBeat.o(17759);
                        return;
                    }
                    FileLruCache.access$100(FileLruCache.this, str, newFile);
                    AppMethodBeat.o(17759);
                }
            }), 8192);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", str);
                if (!Utility.isNullOrEmpty(str2)) {
                    jSONObject.put(HEADER_CACHE_CONTENT_TAG_KEY, str2);
                }
                StreamHeader.writeHeader(bufferedOutputStream, jSONObject);
                AppMethodBeat.o(17794);
                return bufferedOutputStream;
            } catch (JSONException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: ".concat(String.valueOf(e2)));
                IOException iOException2 = new IOException(e2.getMessage());
                AppMethodBeat.o(17794);
                throw iOException2;
            } catch (Throwable th) {
                bufferedOutputStream.close();
                AppMethodBeat.o(17794);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: ".concat(String.valueOf(e3)));
            IOException iOException3 = new IOException(e3.getMessage());
            AppMethodBeat.o(17794);
            throw iOException3;
        }
    }

    public final void clearCache() {
        AppMethodBeat.i(17795);
        final File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.internal.FileLruCache.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(17760);
                    for (File file : listFiles) {
                        file.delete();
                    }
                    AppMethodBeat.o(17760);
                }
            });
        }
        AppMethodBeat.o(17795);
    }

    public final String getLocation() {
        AppMethodBeat.i(17796);
        String path = this.directory.getPath();
        AppMethodBeat.o(17796);
        return path;
    }

    private void renameToTargetAndTrim(String str, File file) {
        AppMethodBeat.i(17797);
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
        AppMethodBeat.o(17797);
    }

    public final InputStream interceptAndPut(String str, InputStream inputStream) {
        AppMethodBeat.i(17798);
        CopyingInputStream copyingInputStream = new CopyingInputStream(inputStream, openPutStream(str));
        AppMethodBeat.o(17798);
        return copyingInputStream;
    }

    public final String toString() {
        AppMethodBeat.i(17799);
        String str = "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
        AppMethodBeat.o(17799);
        return str;
    }

    private void postTrim() {
        AppMethodBeat.i(17800);
        synchronized (this.lock) {
            try {
                if (!this.isTrimPending) {
                    this.isTrimPending = true;
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        /* class com.facebook.internal.FileLruCache.AnonymousClass3 */

                        public void run() {
                            AppMethodBeat.i(17761);
                            FileLruCache.access$200(FileLruCache.this);
                            AppMethodBeat.o(17761);
                        }
                    });
                }
            } finally {
                AppMethodBeat.o(17800);
            }
        }
    }

    private void trim() {
        AppMethodBeat.i(17801);
        synchronized (this.lock) {
            try {
                this.isTrimPending = false;
                this.isTrimInProgress = true;
            } finally {
                AppMethodBeat.o(17801);
            }
        }
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            long j2 = 0;
            long j3 = 0;
            File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
            if (listFiles != null) {
                for (File file : listFiles) {
                    ModifiedFile modifiedFile = new ModifiedFile(file);
                    priorityQueue.add(modifiedFile);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                    j2 += file.length();
                    j3++;
                }
            }
            while (true) {
                if (j2 > ((long) this.limits.getByteCount()) || j3 > ((long) this.limits.getFileCount())) {
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file2.getName());
                    j2 -= file2.length();
                    j3--;
                    file2.delete();
                } else {
                    synchronized (this.lock) {
                        try {
                            this.isTrimInProgress = false;
                            this.lock.notifyAll();
                        } finally {
                            AppMethodBeat.o(17801);
                        }
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            AppMethodBeat.o(17801);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() {
            /* class com.facebook.internal.FileLruCache.BufferFile.AnonymousClass1 */

            public final boolean accept(File file, String str) {
                AppMethodBeat.i(17762);
                if (!str.startsWith(BufferFile.FILE_NAME_PREFIX)) {
                    AppMethodBeat.o(17762);
                    return true;
                }
                AppMethodBeat.o(17762);
                return false;
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() {
            /* class com.facebook.internal.FileLruCache.BufferFile.AnonymousClass2 */

            public final boolean accept(File file, String str) {
                AppMethodBeat.i(17763);
                boolean startsWith = str.startsWith(BufferFile.FILE_NAME_PREFIX);
                AppMethodBeat.o(17763);
                return startsWith;
            }
        };

        private BufferFile() {
        }

        static {
            AppMethodBeat.i(17766);
            AppMethodBeat.o(17766);
        }

        static void deleteAll(File file) {
            AppMethodBeat.i(17764);
            File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
            AppMethodBeat.o(17764);
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File file) {
            AppMethodBeat.i(17765);
            File file2 = new File(file, FILE_NAME_PREFIX + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
            AppMethodBeat.o(17765);
            return file2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        private StreamHeader() {
        }

        static void writeHeader(OutputStream outputStream, JSONObject jSONObject) {
            AppMethodBeat.i(17787);
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
            AppMethodBeat.o(17787);
        }

        static JSONObject readHeader(InputStream inputStream) {
            int i2 = 0;
            AppMethodBeat.i(17788);
            if (inputStream.read() != 0) {
                AppMethodBeat.o(17788);
                return null;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    AppMethodBeat.o(17788);
                    return null;
                }
                i3 = (i3 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i3];
            while (i2 < i3) {
                int read2 = inputStream.read(bArr, i2, i3 - i2);
                if (read2 <= 0) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i2) + " when expected " + i3);
                    AppMethodBeat.o(17788);
                    return null;
                }
                i2 += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (!(nextValue instanceof JSONObject)) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                    AppMethodBeat.o(17788);
                    return null;
                }
                JSONObject jSONObject = (JSONObject) nextValue;
                AppMethodBeat.o(17788);
                return jSONObject;
            } catch (JSONException e2) {
                IOException iOException = new IOException(e2.getMessage());
                AppMethodBeat.o(17788);
                throw iOException;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class CloseCallbackOutputStream extends OutputStream {
        final StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            AppMethodBeat.i(17767);
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
                AppMethodBeat.o(17767);
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            AppMethodBeat.i(17768);
            this.innerStream.flush();
            AppMethodBeat.o(17768);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(17769);
            this.innerStream.write(bArr, i2, i3);
            AppMethodBeat.o(17769);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            AppMethodBeat.i(17770);
            this.innerStream.write(bArr);
            AppMethodBeat.o(17770);
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            AppMethodBeat.i(17771);
            this.innerStream.write(i2);
            AppMethodBeat.o(17771);
        }
    }

    static final class CopyingInputStream extends InputStream {
        final InputStream input;
        final OutputStream output;

        CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            this.input = inputStream;
            this.output = outputStream;
        }

        @Override // java.io.InputStream
        public final int available() {
            AppMethodBeat.i(17772);
            int available = this.input.available();
            AppMethodBeat.o(17772);
            return available;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public final void close() {
            AppMethodBeat.i(17773);
            try {
                this.input.close();
            } finally {
                this.output.close();
                AppMethodBeat.o(17773);
            }
        }

        public final void mark(int i2) {
            AppMethodBeat.i(17774);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(17774);
            throw unsupportedOperationException;
        }

        public final boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr) {
            AppMethodBeat.i(17775);
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            AppMethodBeat.o(17775);
            return read;
        }

        @Override // java.io.InputStream
        public final int read() {
            AppMethodBeat.i(17776);
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            AppMethodBeat.o(17776);
            return read;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(17777);
            int read = this.input.read(bArr, i2, i3);
            if (read > 0) {
                this.output.write(bArr, i2, read);
            }
            AppMethodBeat.o(17777);
            return read;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            AppMethodBeat.i(17778);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(17778);
            throw unsupportedOperationException;
        }

        @Override // java.io.InputStream
        public final long skip(long j2) {
            AppMethodBeat.i(17779);
            byte[] bArr = new byte[1024];
            long j3 = 0;
            while (true) {
                if (j3 >= j2) {
                    AppMethodBeat.o(17779);
                    break;
                }
                int read = read(bArr, 0, (int) Math.min(j2 - j3, 1024L));
                if (read < 0) {
                    AppMethodBeat.o(17779);
                    break;
                }
                j3 += (long) read;
            }
            return j3;
        }
    }

    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        /* access modifiers changed from: package-private */
        public final int getByteCount() {
            return this.byteCount;
        }

        /* access modifiers changed from: package-private */
        public final int getFileCount() {
            return this.fileCount;
        }

        /* access modifiers changed from: package-private */
        public final void setByteCount(int i2) {
            AppMethodBeat.i(17780);
            if (i2 < 0) {
                InvalidParameterException invalidParameterException = new InvalidParameterException("Cache byte-count limit must be >= 0");
                AppMethodBeat.o(17780);
                throw invalidParameterException;
            }
            this.byteCount = i2;
            AppMethodBeat.o(17780);
        }

        /* access modifiers changed from: package-private */
        public final void setFileCount(int i2) {
            AppMethodBeat.i(17781);
            if (i2 < 0) {
                InvalidParameterException invalidParameterException = new InvalidParameterException("Cache file count limit must be >= 0");
                AppMethodBeat.o(17781);
                throw invalidParameterException;
            }
            this.fileCount = i2;
            AppMethodBeat.o(17781);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ModifiedFile implements Comparable<ModifiedFile> {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(ModifiedFile modifiedFile) {
            AppMethodBeat.i(17786);
            int compareTo = compareTo(modifiedFile);
            AppMethodBeat.o(17786);
            return compareTo;
        }

        ModifiedFile(File file2) {
            AppMethodBeat.i(17782);
            this.file = file2;
            this.modified = file2.lastModified();
            AppMethodBeat.o(17782);
        }

        /* access modifiers changed from: package-private */
        public final File getFile() {
            return this.file;
        }

        /* access modifiers changed from: package-private */
        public final long getModified() {
            return this.modified;
        }

        public final int compareTo(ModifiedFile modifiedFile) {
            AppMethodBeat.i(17783);
            if (getModified() < modifiedFile.getModified()) {
                AppMethodBeat.o(17783);
                return -1;
            } else if (getModified() > modifiedFile.getModified()) {
                AppMethodBeat.o(17783);
                return 1;
            } else {
                int compareTo = getFile().compareTo(modifiedFile.getFile());
                AppMethodBeat.o(17783);
                return compareTo;
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(17784);
            if (!(obj instanceof ModifiedFile) || compareTo((ModifiedFile) obj) != 0) {
                AppMethodBeat.o(17784);
                return false;
            }
            AppMethodBeat.o(17784);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(17785);
            int hashCode = ((this.file.hashCode() + 1073) * 37) + ((int) (this.modified % 2147483647L));
            AppMethodBeat.o(17785);
            return hashCode;
        }
    }
}
