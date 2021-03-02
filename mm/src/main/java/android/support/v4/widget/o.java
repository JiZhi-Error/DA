package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class o extends f {
    private int Ve;
    private int Vf;
    private LayoutInflater mInflater;

    @Deprecated
    public o(Context context, int i2) {
        super(context);
        this.Vf = i2;
        this.Ve = i2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.f
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.Ve, viewGroup, false);
    }

    @Override // android.support.v4.widget.f
    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.Vf, viewGroup, false);
    }
}
