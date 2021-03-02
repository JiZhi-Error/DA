package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final Object workLock;

    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    static {
        AppMethodBeat.i(18046);
        AppMethodBeat.o(18046);
    }

    static /* synthetic */ void access$000(WorkQueue workQueue, WorkNode workNode) {
        AppMethodBeat.i(18045);
        workQueue.finishItemAndStartNew(workNode);
        AppMethodBeat.o(18045);
    }

    public WorkQueue() {
        this(8);
    }

    public WorkQueue(int i2) {
        this(i2, FacebookSdk.getExecutor());
        AppMethodBeat.i(18037);
        AppMethodBeat.o(18037);
    }

    public WorkQueue(int i2, Executor executor2) {
        AppMethodBeat.i(18038);
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i2;
        this.executor = executor2;
        AppMethodBeat.o(18038);
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        AppMethodBeat.i(18039);
        WorkItem addActiveWorkItem = addActiveWorkItem(runnable, true);
        AppMethodBeat.o(18039);
        return addActiveWorkItem;
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        AppMethodBeat.i(18040);
        WorkNode workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            try {
                this.pendingJobs = workNode.addToList(this.pendingJobs, z);
            } catch (Throwable th) {
                AppMethodBeat.o(18040);
                throw th;
            }
        }
        startItem();
        AppMethodBeat.o(18040);
        return workNode;
    }

    public void validate() {
        AppMethodBeat.i(18041);
        synchronized (this.workLock) {
            int i2 = 0;
            try {
                if (this.runningJobs != null) {
                    WorkNode workNode = this.runningJobs;
                    do {
                        workNode.verify(true);
                        i2++;
                        workNode = workNode.getNext();
                    } while (workNode != this.runningJobs);
                }
                if (!$assertionsDisabled && this.runningCount != i2) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(18041);
                    throw assertionError;
                }
            } finally {
                AppMethodBeat.o(18041);
            }
        }
    }

    private void startItem() {
        AppMethodBeat.i(18042);
        finishItemAndStartNew(null);
        AppMethodBeat.o(18042);
    }

    private void finishItemAndStartNew(WorkNode workNode) {
        AppMethodBeat.i(18043);
        WorkNode workNode2 = null;
        synchronized (this.workLock) {
            if (workNode != null) {
                try {
                    this.runningJobs = workNode.removeFromList(this.runningJobs);
                    this.runningCount--;
                } catch (Throwable th) {
                    AppMethodBeat.o(18043);
                    throw th;
                }
            }
            if (this.runningCount < this.maxConcurrent && (workNode2 = this.pendingJobs) != null) {
                this.pendingJobs = workNode2.removeFromList(this.pendingJobs);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setIsRunning(true);
            }
        }
        if (workNode2 != null) {
            execute(workNode2);
        }
        AppMethodBeat.o(18043);
    }

    private void execute(final WorkNode workNode) {
        AppMethodBeat.i(18044);
        this.executor.execute(new Runnable() {
            /* class com.facebook.internal.WorkQueue.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(18030);
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.access$000(WorkQueue.this, workNode);
                    AppMethodBeat.o(18030);
                }
            }
        });
        AppMethodBeat.o(18044);
    }

    /* access modifiers changed from: package-private */
    public class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        static {
            AppMethodBeat.i(18036);
            AppMethodBeat.o(18036);
        }

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            AppMethodBeat.i(18031);
            synchronized (WorkQueue.this.workLock) {
                try {
                    if (!isRunning()) {
                        WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                        return true;
                    }
                    AppMethodBeat.o(18031);
                    return false;
                } finally {
                    AppMethodBeat.o(18031);
                }
            }
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            AppMethodBeat.i(18032);
            synchronized (WorkQueue.this.workLock) {
                try {
                    if (!isRunning()) {
                        WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                        WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
                    }
                } finally {
                    AppMethodBeat.o(18032);
                }
            }
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        /* access modifiers changed from: package-private */
        public Runnable getCallback() {
            return this.callback;
        }

        /* access modifiers changed from: package-private */
        public WorkNode getNext() {
            return this.next;
        }

        /* access modifiers changed from: package-private */
        public void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        /* access modifiers changed from: package-private */
        public WorkNode addToList(WorkNode workNode, boolean z) {
            WorkNode workNode2;
            AppMethodBeat.i(18033);
            if (!$assertionsDisabled && this.next != null) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(18033);
                throw assertionError;
            } else if ($assertionsDisabled || this.prev == null) {
                if (workNode == null) {
                    this.prev = this;
                    this.next = this;
                    workNode2 = this;
                } else {
                    this.next = workNode;
                    this.prev = workNode.prev;
                    WorkNode workNode3 = this.next;
                    this.prev.next = this;
                    workNode3.prev = this;
                    workNode2 = workNode;
                }
                if (z) {
                    AppMethodBeat.o(18033);
                    return this;
                }
                AppMethodBeat.o(18033);
                return workNode2;
            } else {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(18033);
                throw assertionError2;
            }
        }

        /* access modifiers changed from: package-private */
        public WorkNode removeFromList(WorkNode workNode) {
            AppMethodBeat.i(18034);
            if (!$assertionsDisabled && this.next == null) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(18034);
                throw assertionError;
            } else if ($assertionsDisabled || this.prev != null) {
                if (workNode == this) {
                    if (this.next == this) {
                        workNode = null;
                    } else {
                        workNode = this.next;
                    }
                }
                this.next.prev = this.prev;
                this.prev.next = this.next;
                this.prev = null;
                this.next = null;
                AppMethodBeat.o(18034);
                return workNode;
            } else {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(18034);
                throw assertionError2;
            }
        }

        /* access modifiers changed from: package-private */
        public void verify(boolean z) {
            AppMethodBeat.i(18035);
            if (!$assertionsDisabled && this.prev.next != this) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(18035);
                throw assertionError;
            } else if (!$assertionsDisabled && this.next.prev != this) {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(18035);
                throw assertionError2;
            } else if ($assertionsDisabled || isRunning() == z) {
                AppMethodBeat.o(18035);
            } else {
                AssertionError assertionError3 = new AssertionError();
                AppMethodBeat.o(18035);
                throw assertionError3;
            }
        }
    }
}
