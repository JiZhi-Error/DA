package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class f extends BaseAdapter implements g.a, Filterable {
    protected boolean Tm = false;
    protected boolean Tn = true;
    protected Cursor To = null;
    protected int Tp;
    protected a Tq;
    protected DataSetObserver Tr;
    protected g Ts;
    protected FilterQueryProvider Tt;
    protected Context mContext;

    public abstract void a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public f(Context context) {
        this.mContext = context;
        this.Tp = -1;
        this.Tq = new a();
        this.Tr = new b();
    }

    @Override // android.support.v4.widget.g.a
    public final Cursor getCursor() {
        return this.To;
    }

    public int getCount() {
        if (!this.Tm || this.To == null) {
            return 0;
        }
        return this.To.getCount();
    }

    public Object getItem(int i2) {
        if (!this.Tm || this.To == null) {
            return null;
        }
        this.To.moveToPosition(i2);
        return this.To;
    }

    public long getItemId(int i2) {
        if (!this.Tm || this.To == null || !this.To.moveToPosition(i2)) {
            return 0;
        }
        return this.To.getLong(this.Tp);
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.Tm) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (!this.To.moveToPosition(i2)) {
            throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(i2)));
        } else {
            if (view == null) {
                view = newView(this.mContext, this.To, viewGroup);
            }
            a(view, this.To);
            return view;
        }
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.Tm) {
            return null;
        }
        this.To.moveToPosition(i2);
        if (view == null) {
            view = newDropDownView(this.mContext, this.To, viewGroup);
        }
        a(view, this.To);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    @Override // android.support.v4.widget.g.a
    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.support.v4.widget.g.a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.Tt != null) {
            return this.Tt.runQuery(charSequence);
        }
        return this.To;
    }

    public Filter getFilter() {
        if (this.Ts == null) {
            this.Ts = new g(this);
        }
        return this.Ts;
    }

    /* access modifiers changed from: protected */
    public final void onContentChanged() {
        if (this.Tn && this.To != null && !this.To.isClosed()) {
            this.Tm = this.To.requery();
        }
    }

    class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            f.this.onContentChanged();
        }
    }

    class b extends DataSetObserver {
        b() {
        }

        public final void onChanged() {
            f.this.Tm = true;
            f.this.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            f.this.Tm = false;
            f.this.notifyDataSetInvalidated();
        }
    }

    @Override // android.support.v4.widget.g.a
    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.To) {
            cursor2 = null;
        } else {
            cursor2 = this.To;
            if (cursor2 != null) {
                if (this.Tq != null) {
                    cursor2.unregisterContentObserver(this.Tq);
                }
                if (this.Tr != null) {
                    cursor2.unregisterDataSetObserver(this.Tr);
                }
            }
            this.To = cursor;
            if (cursor != null) {
                if (this.Tq != null) {
                    cursor.registerContentObserver(this.Tq);
                }
                if (this.Tr != null) {
                    cursor.registerDataSetObserver(this.Tr);
                }
                this.Tp = cursor.getColumnIndexOrThrow("_id");
                this.Tm = true;
                notifyDataSetChanged();
            } else {
                this.Tp = -1;
                this.Tm = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
