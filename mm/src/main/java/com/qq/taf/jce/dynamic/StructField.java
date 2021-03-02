package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;

public class StructField extends JceField {
    private static final Comparator<JceField> tagComp = new Comparator<JceField>() {
        /* class com.qq.taf.jce.dynamic.StructField.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(JceField jceField, JceField jceField2) {
            AppMethodBeat.i(109564);
            int compare = compare(jceField, jceField2);
            AppMethodBeat.o(109564);
            return compare;
        }

        public int compare(JceField jceField, JceField jceField2) {
            AppMethodBeat.i(109563);
            int tag = jceField.getTag() - jceField2.getTag();
            AppMethodBeat.o(109563);
            return tag;
        }
    };
    private JceField[] data;

    static {
        AppMethodBeat.i(109565);
        AppMethodBeat.o(109565);
    }

    StructField(JceField[] jceFieldArr, int i2) {
        super(i2);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public boolean setByTag(int i2, JceField jceField) {
        AppMethodBeat.i(109566);
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i2), tagComp);
        if (binarySearch >= 0) {
            this.data[binarySearch] = jceField;
            AppMethodBeat.o(109566);
            return true;
        }
        int i3 = (-binarySearch) - 1;
        JceField[] jceFieldArr = new JceField[(this.data.length + 1)];
        for (int i4 = 0; i4 < i3; i4++) {
            jceFieldArr[i4] = this.data[i4];
        }
        jceFieldArr[i3] = jceField;
        while (i3 < this.data.length) {
            jceFieldArr[i3 + 1] = this.data[i3];
            i3++;
        }
        AppMethodBeat.o(109566);
        return false;
    }

    public JceField getFieldByTag(int i2) {
        AppMethodBeat.i(109567);
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i2), tagComp);
        if (binarySearch >= 0) {
            JceField jceField = this.data[binarySearch];
            AppMethodBeat.o(109567);
            return jceField;
        }
        AppMethodBeat.o(109567);
        return null;
    }
}
