package com.tencent.tbs.reader.external;

public interface ITbsReaderAtom {
    public static final int TBS_READER_ATOM_SUCCESS = 0;
    public static final int TBS_READER_ATOM_TYPE_TOKEN = 0;

    int getAtomType();

    int init(Object obj);
}
