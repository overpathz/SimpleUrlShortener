CREATE TABLE IF NOT EXISTS shortened_urls (
    id TEXT PRIMARY KEY ,
    original_url TEXT,
    title TEXT,
    created_at TIMESTAMP DEFAULT NOW()
)
