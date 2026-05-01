CREATE TYPE transaction_type AS ENUM ('BUY', 'SELL');
CREATE TYPE interest_rate_period AS ENUM ('MONTHLY', 'ANNUAL');

CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL
);

CREATE TABLE asset_types (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    income_generating BOOLEAN NOT NULL
);

CREATE TABLE assets (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    symbol VARCHAR(10) NOT NULL,
    symbol_url TEXT,
    created_at TIMESTAMPTZ NOT NULL,
    asset_type_id BIGINT NOT NULL,
    interest_rate NUMERIC(3,2),
    interest_rate_period interest_rate_period,
    CONSTRAINT fk_asset_type
        FOREIGN KEY (asset_type_id)
        REFERENCES asset_types(id)
);

CREATE TABLE transactions (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    asset_id BIGINT NOT NULL,
    quantity NUMERIC(18,8) NOT NULL,
    price NUMERIC(18,2) NOT NULL,
    type transaction_type NOT NULL,
    transaction_at TIMESTAMPTZ NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    CONSTRAINT fk_transaction_asset
        FOREIGN KEY (asset_id)
        REFERENCES assets(id),
    CONSTRAINT fk_transaction_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);

CREATE TABLE asset_price_histories (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    asset_id BIGINT NOT NULL,
    price NUMERIC(18,2) NOT NULL,
    collected_at TIMESTAMPTZ NOT NULL,
    CONSTRAINT fk_price_asset
        FOREIGN KEY (asset_id)
        REFERENCES assets(id)
);
