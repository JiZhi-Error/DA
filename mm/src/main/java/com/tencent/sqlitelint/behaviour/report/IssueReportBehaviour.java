package com.tencent.sqlitelint.behaviour.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import java.util.List;

public class IssueReportBehaviour extends BaseBehaviour {
    private final IReportDelegate mReportDelegate;

    public interface IReportDelegate {
        void report(SQLiteLintIssue sQLiteLintIssue);
    }

    public IssueReportBehaviour(IReportDelegate iReportDelegate) {
        this.mReportDelegate = iReportDelegate;
    }

    @Override // com.tencent.sqlitelint.IOnIssuePublishListener
    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(52938);
        if (this.mReportDelegate != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.mReportDelegate.report(list.get(i2));
            }
        }
        AppMethodBeat.o(52938);
    }
}
