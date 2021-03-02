package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.d;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle> implements Serializable {
    private int Pc;
    protected LinkedList<RectF> RAL;
    public CharacterStyle RAM;
    private int avh;

    public abstract void a(Canvas canvas, TextPaint textPaint, List<d> list);

    b(int i2, int i3, CharacterStyle characterStyle) {
        this.avh = i2;
        this.Pc = i3;
        this.RAM = characterStyle;
    }

    /* access modifiers changed from: package-private */
    public final void kb(List<d> list) {
        if (this.RAL == null) {
            this.RAL = new LinkedList<>();
            for (d dVar : list) {
                if (dVar.avh <= this.avh && this.Pc < dVar.Pc) {
                    this.RAL.add(dVar.mo(this.avh, this.Pc));
                    return;
                } else if (dVar.avh <= this.avh && this.avh < dVar.Pc && dVar.Pc <= this.Pc) {
                    this.RAL.add(dVar.mo(this.avh, dVar.Pc));
                } else if (this.avh < dVar.avh && this.Pc < dVar.Pc && this.Pc >= dVar.avh) {
                    this.RAL.add(dVar.mo(dVar.avh, this.Pc));
                    return;
                } else if (this.avh < dVar.avh && this.Pc >= dVar.Pc) {
                    this.RAL.add(dVar.mo(dVar.avh, dVar.Pc));
                }
            }
        }
    }

    public final boolean aF(float f2, float f3) {
        if (this.RAL == null) {
            return false;
        }
        Iterator<RectF> it = this.RAL.iterator();
        while (it.hasNext()) {
            if (it.next().contains(f2, f3)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!(bVar.avh == this.avh && bVar.Pc == this.Pc)) {
            return false;
        }
        for (int i2 = 0; i2 < this.RAL.size(); i2++) {
            if (!this.RAL.get(i2).equals(bVar.RAL.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.RAL.size(); i3++) {
            i2 += this.RAL.get(i3).hashCode();
        }
        return this.avh + this.Pc + i2;
    }

    public String toString() {
        return "CharacterBgStyle{mRectFList=" + this.RAL + ", mStart=" + this.avh + ", mEnd=" + this.Pc + '}';
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.avh);
        objectOutputStream.writeInt(this.Pc);
        objectOutputStream.writeInt(this.RAL.size());
        Iterator<RectF> it = this.RAL.iterator();
        while (it.hasNext()) {
            RectF next = it.next();
            objectOutputStream.writeFloat(next.left);
            objectOutputStream.writeFloat(next.top);
            objectOutputStream.writeFloat(next.right);
            objectOutputStream.writeFloat(next.bottom);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.avh = objectInputStream.readInt();
        this.Pc = objectInputStream.readInt();
        int readInt = objectInputStream.readInt();
        this.RAL = new LinkedList<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.RAL.add(new RectF(objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat(), objectInputStream.readFloat()));
        }
    }
}
