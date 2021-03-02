package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;

public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ List<GraphResponse> doInBackground(Void[] voidArr) {
        AppMethodBeat.i(17169);
        List<GraphResponse> doInBackground = doInBackground(voidArr);
        AppMethodBeat.o(17169);
        return doInBackground;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(List<GraphResponse> list) {
        AppMethodBeat.i(17168);
        onPostExecute(list);
        AppMethodBeat.o(17168);
    }

    static {
        AppMethodBeat.i(17170);
        AppMethodBeat.o(17170);
    }

    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch(graphRequestArr));
        AppMethodBeat.i(17160);
        AppMethodBeat.o(17160);
    }

    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
        AppMethodBeat.i(17161);
        AppMethodBeat.o(17161);
    }

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch(graphRequestArr));
        AppMethodBeat.i(17162);
        AppMethodBeat.o(17162);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
        AppMethodBeat.i(17163);
        AppMethodBeat.o(17163);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.requests = graphRequestBatch;
        this.connection = httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public final Exception getException() {
        return this.exception;
    }

    /* access modifiers changed from: protected */
    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    public String toString() {
        AppMethodBeat.i(17164);
        String str = "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + "}";
        AppMethodBeat.o(17164);
        return str;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Handler handler;
        AppMethodBeat.i(17165);
        super.onPreExecute();
        if (FacebookSdk.isDebugEnabled()) {
            Utility.logd(TAG, String.format("execute async task: %s", this));
        }
        if (this.requests.getCallbackHandler() == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.requests.setCallbackHandler(handler);
        }
        AppMethodBeat.o(17165);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<GraphResponse> list) {
        AppMethodBeat.i(17166);
        super.onPostExecute((Object) list);
        if (this.exception != null) {
            Utility.logd(TAG, String.format("onPostExecute: exception encountered during request: %s", this.exception.getMessage()));
        }
        AppMethodBeat.o(17166);
    }

    /* access modifiers changed from: protected */
    public List<GraphResponse> doInBackground(Void... voidArr) {
        AppMethodBeat.i(17167);
        try {
            if (this.connection == null) {
                List<GraphResponse> executeAndWait = this.requests.executeAndWait();
                AppMethodBeat.o(17167);
                return executeAndWait;
            }
            List<GraphResponse> executeConnectionAndWait = GraphRequest.executeConnectionAndWait(this.connection, this.requests);
            AppMethodBeat.o(17167);
            return executeConnectionAndWait;
        } catch (Exception e2) {
            this.exception = e2;
            AppMethodBeat.o(17167);
            return null;
        }
    }
}
