ALTER TABLE assets
RENAME COLUMN symbol_url TO logo_url;

ALTER TABLE assets
ADD CONSTRAINT uq_asset_symbol UNIQUE (symbol);

ALTER TABLE asset_types
ADD CONSTRAINT uq_asset_type_name UNIQUE (name);
