package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataRangeTracker {
    private static final long LOCK_INTERVAL = 1000;
    private static final String TAG = "DataRangeTracker";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Comparator<Range> mComparator = new Comparator<Range>() {
        /* class com.tencent.qqmusic.mediaplayer.DataRangeTracker.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Range range, Range range2) {
            AppMethodBeat.i(76415);
            int compare = compare(range, range2);
            AppMethodBeat.o(76415);
            return compare;
        }

        public int compare(Range range, Range range2) {
            AppMethodBeat.i(76414);
            int i2 = (int) (range.first - range2.first);
            AppMethodBeat.o(76414);
            return i2;
        }
    };
    private final ArrayList<Range> mDownloadDataList = new ArrayList<>();
    private long mFileTotalSize = 0;
    private long waitingPosition;
    private int waitingSize;

    public interface LockJudgerCallback {
        boolean isToAbandonLock();
    }

    public DataRangeTracker() {
        AppMethodBeat.i(76725);
        AppMethodBeat.o(76725);
    }

    public void addRange(long j2, long j3, boolean z) {
        Range range;
        AppMethodBeat.i(190288);
        if (j2 > j3) {
            Logger.e(TAG, "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(190288);
            return;
        }
        this.lock.writeLock().lock();
        try {
            ArrayList arrayList = new ArrayList();
            this.mDownloadDataList.add(new Range(j2, j3));
            Collections.sort(this.mDownloadDataList, this.mComparator);
            int size = this.mDownloadDataList.size() - 1;
            Range range2 = this.mDownloadDataList.get(0);
            if (size > 0) {
                int i2 = 1;
                Range range3 = range2;
                while (i2 <= size) {
                    Range range4 = this.mDownloadDataList.get(i2);
                    if (range3.second + 1 < range4.first) {
                        arrayList.add(new Range(range3.first, range3.second));
                        range = new Range(range4.first, range4.second);
                    } else {
                        range = new Range(range3.first, Math.max(range3.second, range4.second));
                    }
                    if (i2 >= size) {
                        arrayList.add(range);
                    }
                    i2++;
                    range3 = range;
                }
                this.mDownloadDataList.clear();
                this.mDownloadDataList.addAll(arrayList);
            }
            boolean z2 = this.waitingPosition >= 0 && this.waitingSize > 0 && isCached(this.waitingPosition, this.waitingSize);
            this.lock.writeLock().unlock();
            if (z2) {
                Logger.i(TAG, "[addRange] notify position: " + this.waitingPosition + ", size: " + this.waitingSize);
                synchronized (this) {
                    if (z) {
                        try {
                            unlock();
                        } catch (Throwable th) {
                            AppMethodBeat.o(190288);
                            throw th;
                        }
                    }
                    this.waitingPosition = 0;
                    this.waitingSize = 0;
                }
                AppMethodBeat.o(190288);
                return;
            }
            AppMethodBeat.o(190288);
        } catch (Throwable th2) {
            this.lock.writeLock().unlock();
            AppMethodBeat.o(190288);
            throw th2;
        }
    }

    public void setFileTotalSize(long j2) {
        this.mFileTotalSize = j2;
    }

    public long findStart(long j2) {
        AppMethodBeat.i(76727);
        lockRead();
        try {
            int size = this.mDownloadDataList.size();
            if (size == 0) {
                unlockRead();
                AppMethodBeat.o(76727);
                return -1;
            }
            long j3 = this.mDownloadDataList.get(0).second + 1;
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 < this.mDownloadDataList.get(i2).first) {
                    unlockRead();
                    AppMethodBeat.o(76727);
                    return j3;
                }
                j3 = this.mDownloadDataList.get(i2).second + 1;
                if (j2 <= this.mDownloadDataList.get(i2).second) {
                    return this.mDownloadDataList.get(i2).second + 1;
                }
            }
            long j4 = this.mDownloadDataList.get(this.mDownloadDataList.size() - 1).second + 1;
            unlockRead();
            AppMethodBeat.o(76727);
            return j4;
        } finally {
            unlockRead();
            AppMethodBeat.o(76727);
        }
    }

    /* access modifiers changed from: package-private */
    public long findEnd(long j2) {
        AppMethodBeat.i(76728);
        lockRead();
        try {
            int size = this.mDownloadDataList.size();
            if (size == 0) {
                unlockRead();
                AppMethodBeat.o(76728);
                return -1;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (j2 < this.mDownloadDataList.get(i2).first) {
                    long j3 = this.mDownloadDataList.get(i2).first - 1;
                    unlockRead();
                    AppMethodBeat.o(76728);
                    return j3;
                } else if (j2 <= this.mDownloadDataList.get(i2).second && i2 + 1 < size) {
                    return this.mDownloadDataList.get(i2 + 1).first - 1;
                }
            }
            unlockRead();
            AppMethodBeat.o(76728);
            return 0;
        } finally {
            unlockRead();
            AppMethodBeat.o(76728);
        }
    }

    public boolean isCached(long j2, int i2) {
        boolean z = false;
        AppMethodBeat.i(76729);
        lockRead();
        try {
            long findStart = findStart(j2);
            long findStart2 = findStart(((long) i2) + j2);
            long findEnd = findEnd(j2);
            long findEnd2 = findEnd(((long) i2) + j2);
            if (findStart == findStart2 && findEnd == findEnd2) {
                if (findEnd == -1) {
                    unlockRead();
                    AppMethodBeat.o(76729);
                } else {
                    long j3 = ((long) i2) + j2;
                    if (this.mFileTotalSize > 0 && j3 > this.mFileTotalSize) {
                        j3 = this.mFileTotalSize;
                    }
                    if (j3 <= findStart) {
                        z = true;
                    }
                    unlockRead();
                    AppMethodBeat.o(76729);
                }
            }
            return z;
        } finally {
            unlockRead();
            AppMethodBeat.o(76729);
        }
    }

    public long getContinuousStart() {
        AppMethodBeat.i(76730);
        lockRead();
        try {
            if (this.mDownloadDataList.size() == 0) {
                unlockRead();
                AppMethodBeat.o(76730);
                return -1;
            }
            return this.mDownloadDataList.get(0).first;
        } finally {
            unlockRead();
            AppMethodBeat.o(76730);
        }
    }

    public long getContinuousEnd() {
        AppMethodBeat.i(76731);
        lockRead();
        try {
            if (this.mDownloadDataList.size() == 0) {
                unlockRead();
                AppMethodBeat.o(76731);
                return -1;
            }
            return this.mDownloadDataList.get(0).second;
        } finally {
            unlockRead();
            AppMethodBeat.o(76731);
        }
    }

    public synchronized boolean lock(long j2, int i2, long j3, LockJudgerCallback lockJudgerCallback) {
        AppMethodBeat.i(190289);
        Logger.i(TAG, "[lock] position = [" + j2 + "]. size = [" + i2 + "]. timeout = [" + j3 + "].");
        this.waitingPosition = j2;
        this.waitingSize = i2;
        int i3 = (int) (j3 / 1000);
        if (i3 <= 0) {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            wait(1000);
            if (lockJudgerCallback != null && lockJudgerCallback.isToAbandonLock()) {
                Logger.i(TAG, "lockJudgerCallback.isToAbandonLock() is true, exit the wait loop");
                break;
            } else if (isCached(this.waitingPosition, this.waitingSize)) {
                Logger.i(TAG, "isCached(waitingPosition, waitingSize) is true, exit the wait loop, wawaitingPosition = " + this.waitingPosition + ", waitingSize = " + this.waitingSize);
                break;
            } else {
                Logger.i(TAG, "continue [lock] position = [" + j2 + "]. size = [" + i2 + "]. totalSize = [" + this.mFileTotalSize + "]. findStart(position) = [" + findStart(j2) + "]. i = " + i4);
                i4++;
            }
        }
        AppMethodBeat.o(190289);
        return true;
    }

    public void block() {
        AppMethodBeat.i(76733);
        Logger.i(TAG, "[block]");
        AppMethodBeat.o(76733);
    }

    public void unblock() {
        AppMethodBeat.i(76734);
        Logger.i(TAG, "[unblock]");
        AppMethodBeat.o(76734);
    }

    public void abandonLock() {
        AppMethodBeat.i(76735);
        Logger.i(TAG, "[abandonLock]");
        unblock();
        unlock();
        AppMethodBeat.o(76735);
    }

    private void lockRead() {
        AppMethodBeat.i(76737);
        this.lock.readLock().lock();
        AppMethodBeat.o(76737);
    }

    private void unlockRead() {
        AppMethodBeat.i(76738);
        this.lock.readLock().unlock();
        AppMethodBeat.o(76738);
    }

    private synchronized void unlock() {
        AppMethodBeat.i(76739);
        Logger.i(TAG, "[unlock].");
        notifyAll();
        AppMethodBeat.o(76739);
    }

    /* access modifiers changed from: package-private */
    public static class Range {
        private final long first;
        private final long second;

        private Range(long j2, long j3) {
            this.first = j2;
            this.second = j3;
        }

        public String toString() {
            AppMethodBeat.i(76669);
            String str = "[" + this.first + ", " + this.second + ']';
            AppMethodBeat.o(76669);
            return str;
        }
    }
}
