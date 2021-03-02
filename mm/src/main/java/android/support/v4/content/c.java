package android.support.v4.content;

import android.content.Context;
import android.support.v4.e.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    b<D> mListener;
    a<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    public interface a<D> {
    }

    public interface b<D> {
        void m(D d2);
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void deliverResult(D d2) {
        if (this.mListener != null) {
            this.mListener.m(d2);
        }
    }

    public void deliverCancellation() {
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public void registerListener(int i2, b<D> bVar) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = bVar;
        this.mId = i2;
    }

    public void unregisterListener(b<D> bVar) {
        if (this.mListener == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.mListener != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.mListener = null;
        }
    }

    public void registerOnLoadCanceledListener(a<D> aVar) {
        if (this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = aVar;
    }

    public void unregisterOnLoadCanceledListener(a<D> aVar) {
        if (this.mOnLoadCanceledListener == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.mOnLoadCanceledListener != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.mOnLoadCanceledListener = null;
        }
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        return false;
    }

    public void forceLoad() {
        onForceLoad();
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public String dataToString(D d2) {
        StringBuilder sb = new StringBuilder(64);
        e.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        e.a(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }
}
