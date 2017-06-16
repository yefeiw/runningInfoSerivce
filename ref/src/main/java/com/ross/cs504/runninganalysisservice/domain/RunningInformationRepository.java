package com.ross.cs504.runninganalysisservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {
    List<RunningInformation> findByOrderByHeartRateDesc();
}
