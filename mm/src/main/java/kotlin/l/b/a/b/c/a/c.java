package kotlin.l.b.a.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c implements a {
    FROM_IDE,
    FROM_BACKEND,
    FROM_TEST,
    FROM_BUILTINS,
    WHEN_CHECK_DECLARATION_CONFLICTS,
    WHEN_CHECK_OVERRIDES,
    FOR_SCRIPT,
    FROM_REFLECTION,
    WHEN_RESOLVE_DECLARATION,
    WHEN_GET_DECLARATION_SCOPE,
    WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS,
    FOR_ALREADY_TRACKED,
    WHEN_GET_ALL_DESCRIPTORS,
    WHEN_TYPING,
    WHEN_GET_SUPER_MEMBERS,
    FOR_NON_TRACKED_SCOPE,
    FROM_SYNTHETIC_SCOPE,
    FROM_DESERIALIZATION,
    FROM_JAVA_LOADER,
    WHEN_GET_LOCAL_VARIABLE,
    WHEN_FIND_BY_FQNAME,
    WHEN_GET_COMPANION_OBJECT,
    FOR_DEFAULT_IMPORTS;

    static {
        AppMethodBeat.i(57524);
        AppMethodBeat.o(57524);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(57526);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(57526);
        return cVar;
    }
}
