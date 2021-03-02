package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    protected _Item MT;
    public a QYM;
    protected Cursor To = null;
    protected int mCount;
    protected Map<Integer, _Item> pQY = null;

    public interface a {
        void fjp();

        void fjq();
    }

    public abstract _Item a(_Item _item, Cursor cursor);

    /* access modifiers changed from: protected */
    public abstract Cursor fki();

    public b(_Item _item) {
        this.MT = _item;
        this.mCount = -1;
        hdm();
    }

    private Cursor getCursor() {
        if (this.To == null || this.To.isClosed()) {
            Assert.assertNotNull(this.To);
        }
        return this.To;
    }

    @Override // com.tencent.mm.vending.base.Vending
    public void destroyAsynchronous() {
        ebf();
    }

    public final void ebf() {
        if (this.pQY != null) {
            this.pQY.clear();
        }
        if (this.To != null) {
            this.To.close();
        }
        this.mCount = -1;
    }

    public final void hdm() {
        if (this.pQY == null) {
            this.pQY = new HashMap();
        }
    }

    @Override // com.tencent.mm.vending.base.b
    public final int hdn() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i2) {
        _Item _item;
        if (this.pQY != null && (_item = this.pQY.get(Integer.valueOf(i2))) != null) {
            return _item;
        }
        if (i2 < 0 || !getCursor().moveToPosition(i2)) {
            return null;
        }
        if (this.pQY == null) {
            return a(this.MT, getCursor());
        }
        _Item a2 = a(null, getCursor());
        this.pQY.put(Integer.valueOf(i2), a2);
        return a2;
    }

    @Override // com.tencent.mm.vending.base.Vending
    public /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.QYM != null) {
            this.QYM.fjp();
        }
        Cursor fki = fki();
        if (this.QYM != null) {
            this.QYM.fjq();
        }
        return fki;
    }
}
