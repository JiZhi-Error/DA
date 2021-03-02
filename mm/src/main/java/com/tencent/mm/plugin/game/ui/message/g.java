package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g<VH extends RecyclerView.v> extends RecyclerView.a<VH> {
    private boolean Tm;
    Cursor To;
    private DataSetObserver Tr;
    private Context mContext;

    public abstract void a(VH vh, Cursor cursor);

    public g(Context context, Cursor cursor) {
        this.mContext = context;
        this.To = cursor;
        this.Tm = cursor != null;
        this.Tr = new a(this, (byte) 0);
        if (this.To != null) {
            this.To.registerDataSetObserver(this.Tr);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        if (!this.Tm || this.To == null) {
            return 0;
        }
        return this.To.getCount();
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void au(boolean z) {
        super.au(true);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(VH vh, int i2) {
        if (!this.Tm) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (!this.To.moveToPosition(i2)) {
            throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(i2)));
        } else {
            a(vh, this.To);
        }
    }

    public final void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    private Cursor swapCursor(Cursor cursor) {
        if (cursor == this.To) {
            return null;
        }
        Cursor cursor2 = this.To;
        if (!(cursor2 == null || this.Tr == null)) {
            cursor2.unregisterDataSetObserver(this.Tr);
        }
        this.To = cursor;
        if (this.To != null) {
            if (this.Tr != null) {
                this.To.registerDataSetObserver(this.Tr);
            }
            this.Tm = true;
            this.atj.notifyChanged();
            return cursor2;
        }
        this.Tm = false;
        this.atj.notifyChanged();
        return cursor2;
    }

    class a extends DataSetObserver {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(183904);
            super.onChanged();
            g.this.Tm = true;
            g.this.atj.notifyChanged();
            AppMethodBeat.o(183904);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(183905);
            super.onInvalidated();
            g.this.Tm = false;
            g.this.atj.notifyChanged();
            AppMethodBeat.o(183905);
        }
    }
}
