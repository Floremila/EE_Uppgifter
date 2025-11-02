CREATE TABLE IF NOT EXISTS messages (
                                        id BIGSERIAL PRIMARY KEY,
                                        message TEXT NOT NULL,
                                        created_at TIMESTAMP NOT NULL DEFAULT NOW()
);
