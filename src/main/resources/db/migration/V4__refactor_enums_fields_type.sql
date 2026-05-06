ALTER TABLE assets
ALTER COLUMN interest_rate_period TYPE VARCHAR(20);

DROP TYPE interest_rate_period;

ALTER TABLE transactions
ALTER COLUMN type TYPE VARCHAR(20);

DROP TYPE transaction_type;