package com.tencent.tbs.reader.external;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsReaderTokenAtom implements ITbsReaderAtom {

    /* renamed from: a  reason: collision with root package name */
    private ITbsReaderAtom f2811a;

    public TbsReaderTokenAtom(ITbsReaderAtom iTbsReaderAtom) {
        this.f2811a = iTbsReaderAtom;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderAtom
    public int getAtomType() {
        return 0;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderAtom
    public int init(Object obj) {
        AppMethodBeat.i(187998);
        if (this.f2811a != null) {
            int init = this.f2811a.init(obj);
            AppMethodBeat.o(187998);
            return init;
        }
        AppMethodBeat.o(187998);
        return -1;
    }
}
