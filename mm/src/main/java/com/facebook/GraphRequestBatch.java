package com.facebook;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch extends AbstractList<GraphRequest> {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private String batchApplicationId;
    private Handler callbackHandler;
    private List<Callback> callbacks;
    private final String id;
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j2, long j3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList
    public /* bridge */ /* synthetic */ void add(int i2, GraphRequest graphRequest) {
        AppMethodBeat.i(17190);
        add(i2, graphRequest);
        AppMethodBeat.o(17190);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public /* bridge */ /* synthetic */ boolean add(GraphRequest graphRequest) {
        AppMethodBeat.i(17193);
        boolean add = add(graphRequest);
        AppMethodBeat.o(17193);
        return add;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList
    public /* bridge */ /* synthetic */ GraphRequest set(int i2, GraphRequest graphRequest) {
        AppMethodBeat.i(17191);
        GraphRequest graphRequest2 = set(i2, graphRequest);
        AppMethodBeat.o(17191);
        return graphRequest2;
    }

    static {
        AppMethodBeat.i(17194);
        AppMethodBeat.o(17194);
    }

    public GraphRequestBatch() {
        AppMethodBeat.i(17171);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
        AppMethodBeat.o(17171);
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        AppMethodBeat.i(17172);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
        AppMethodBeat.o(17172);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(17173);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = Arrays.asList(graphRequestArr);
        AppMethodBeat.o(17173);
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17174);
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
        AppMethodBeat.o(17174);
    }

    public int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public void setTimeout(int i2) {
        AppMethodBeat.i(17175);
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
            AppMethodBeat.o(17175);
            throw illegalArgumentException;
        }
        this.timeoutInMilliseconds = i2;
        AppMethodBeat.o(17175);
    }

    public void addCallback(Callback callback) {
        AppMethodBeat.i(17176);
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
        AppMethodBeat.o(17176);
    }

    public void removeCallback(Callback callback) {
        AppMethodBeat.i(17177);
        this.callbacks.remove(callback);
        AppMethodBeat.o(17177);
    }

    public final boolean add(GraphRequest graphRequest) {
        AppMethodBeat.i(17178);
        boolean add = this.requests.add(graphRequest);
        AppMethodBeat.o(17178);
        return add;
    }

    public final void add(int i2, GraphRequest graphRequest) {
        AppMethodBeat.i(17179);
        this.requests.add(i2, graphRequest);
        AppMethodBeat.o(17179);
    }

    public final void clear() {
        AppMethodBeat.i(17180);
        this.requests.clear();
        AppMethodBeat.o(17180);
    }

    @Override // java.util.List, java.util.AbstractList
    public final GraphRequest get(int i2) {
        AppMethodBeat.i(17181);
        GraphRequest graphRequest = this.requests.get(i2);
        AppMethodBeat.o(17181);
        return graphRequest;
    }

    @Override // java.util.List, java.util.AbstractList
    public final GraphRequest remove(int i2) {
        AppMethodBeat.i(17182);
        GraphRequest remove = this.requests.remove(i2);
        AppMethodBeat.o(17182);
        return remove;
    }

    public final GraphRequest set(int i2, GraphRequest graphRequest) {
        AppMethodBeat.i(17183);
        GraphRequest graphRequest2 = this.requests.set(i2, graphRequest);
        AppMethodBeat.o(17183);
        return graphRequest2;
    }

    public final int size() {
        AppMethodBeat.i(17184);
        int size = this.requests.size();
        AppMethodBeat.o(17184);
        return size;
    }

    /* access modifiers changed from: package-private */
    public final String getId() {
        return this.id;
    }

    /* access modifiers changed from: package-private */
    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    /* access modifiers changed from: package-private */
    public final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    /* access modifiers changed from: package-private */
    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    /* access modifiers changed from: package-private */
    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    public final void setBatchApplicationId(String str) {
        this.batchApplicationId = str;
    }

    public final List<GraphResponse> executeAndWait() {
        AppMethodBeat.i(17185);
        List<GraphResponse> executeAndWaitImpl = executeAndWaitImpl();
        AppMethodBeat.o(17185);
        return executeAndWaitImpl;
    }

    public final GraphRequestAsyncTask executeAsync() {
        AppMethodBeat.i(17186);
        GraphRequestAsyncTask executeAsyncImpl = executeAsyncImpl();
        AppMethodBeat.o(17186);
        return executeAsyncImpl;
    }

    /* access modifiers changed from: package-private */
    public List<GraphResponse> executeAndWaitImpl() {
        AppMethodBeat.i(17187);
        List<GraphResponse> executeBatchAndWait = GraphRequest.executeBatchAndWait(this);
        AppMethodBeat.o(17187);
        return executeBatchAndWait;
    }

    /* access modifiers changed from: package-private */
    public GraphRequestAsyncTask executeAsyncImpl() {
        AppMethodBeat.i(17188);
        GraphRequestAsyncTask executeBatchAsync = GraphRequest.executeBatchAsync(this);
        AppMethodBeat.o(17188);
        return executeBatchAsync;
    }
}
