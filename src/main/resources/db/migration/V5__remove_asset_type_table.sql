ALTER TABLE assets
DROP CONSTRAINT fk_asset_type;

ALTER TABLE assets
DROP COLUMN asset_type_id;

DROP TABLE asset_types;

ALTER TABLE assets
ADD COLUMN asset_type VARCHAR(50) NOT NULL;