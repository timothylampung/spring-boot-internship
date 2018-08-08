package com.timothy.server.user.domain.model;

import com.timothy.server.core.domain.model.DateAudit;

public interface EmgUserRole extends DateAudit {
    void setUserId(long userId);
    void setAccessLevelId(long accessLevelId);
}
