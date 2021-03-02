package com.tencent.sqlitelint.behaviour.persistence;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import java.util.List;

public class PersistenceBehaviour extends BaseBehaviour {
    @Override // com.tencent.sqlitelint.IOnIssuePublishListener
    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(52922);
        IssueStorage.saveIssues(list);
        AppMethodBeat.o(52922);
    }
}
