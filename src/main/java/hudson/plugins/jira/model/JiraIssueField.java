package hudson.plugins.jira.model;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import javax.annotation.Nonnull;

public final class JiraIssueField implements Comparable<JiraIssueField> {

    private final String fieldId;
    private final Object fieldValue;

    public JiraIssueField(String fieldId, Object fieldValue) {
        this.fieldId = fieldId;
        this.fieldValue = fieldValue;
    }

    @Override
    public int compareTo(@Nonnull JiraIssueField o) {
        return ComparisonChain.start()
                .compare(this.fieldId, o.fieldId)
                .result();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fieldId, fieldValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JiraIssueField that = (JiraIssueField) o;
        return Objects.equal(fieldId, that.fieldId) &&
                Objects.equal(fieldValue, that.fieldValue);
    }

    public String getId() {
        return fieldId;
    }

    public Object getValue() {
        return fieldValue;
    }

}
