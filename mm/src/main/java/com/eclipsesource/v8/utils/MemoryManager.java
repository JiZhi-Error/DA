package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class MemoryManager {
    private MemoryManagerReferenceHandler memoryManagerReferenceHandler;
    private ArrayList<V8Value> references = new ArrayList<>();
    private boolean released = false;
    private boolean releasing = false;
    private V8 v8;

    public MemoryManager(V8 v82) {
        AppMethodBeat.i(61659);
        this.v8 = v82;
        this.memoryManagerReferenceHandler = new MemoryManagerReferenceHandler();
        v82.addReferenceHandler(this.memoryManagerReferenceHandler);
        AppMethodBeat.o(61659);
    }

    public int getObjectReferenceCount() {
        AppMethodBeat.i(61660);
        checkReleased();
        int size = this.references.size();
        AppMethodBeat.o(61660);
        return size;
    }

    public void persist(V8Value v8Value) {
        AppMethodBeat.i(61661);
        this.v8.getLocker().checkThread();
        checkReleased();
        this.references.remove(v8Value);
        AppMethodBeat.o(61661);
    }

    public boolean isReleased() {
        return this.released;
    }

    public void release() {
        AppMethodBeat.i(61662);
        this.v8.getLocker().checkThread();
        if (this.released) {
            AppMethodBeat.o(61662);
            return;
        }
        this.releasing = true;
        try {
            Iterator<V8Value> it = this.references.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
            this.references.clear();
            this.releasing = false;
            this.released = true;
            AppMethodBeat.o(61662);
        } catch (Throwable th) {
            this.releasing = false;
            AppMethodBeat.o(61662);
            throw th;
        }
    }

    private void checkReleased() {
        AppMethodBeat.i(61663);
        if (this.released) {
            IllegalStateException illegalStateException = new IllegalStateException("Memory manager released");
            AppMethodBeat.o(61663);
            throw illegalStateException;
        }
        AppMethodBeat.o(61663);
    }

    class MemoryManagerReferenceHandler implements ReferenceHandler {
        private MemoryManagerReferenceHandler() {
        }

        @Override // com.eclipsesource.v8.ReferenceHandler
        public void v8HandleCreated(V8Value v8Value) {
            AppMethodBeat.i(61657);
            MemoryManager.this.references.add(v8Value);
            AppMethodBeat.o(61657);
        }

        @Override // com.eclipsesource.v8.ReferenceHandler
        public void v8HandleDisposed(V8Value v8Value) {
            AppMethodBeat.i(61658);
            if (!MemoryManager.this.releasing) {
                Iterator it = MemoryManager.this.references.iterator();
                while (it.hasNext()) {
                    if (it.next() == v8Value) {
                        it.remove();
                        AppMethodBeat.o(61658);
                        return;
                    }
                }
            }
            AppMethodBeat.o(61658);
        }
    }
}
