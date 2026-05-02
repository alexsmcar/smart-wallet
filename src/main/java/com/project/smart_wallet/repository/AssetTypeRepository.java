package com.project.smart_wallet.repository;

import com.project.smart_wallet.domain.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetTypeRepository extends JpaRepository<AssetType, Long> {

    Optional<AssetTypeRepository> findByName(String name);
}
