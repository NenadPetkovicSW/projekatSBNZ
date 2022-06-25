import pandas as pd
df = pd.read_csv ('tcc_music.csv')

string = "INSERT INTO SONG (ID, ARTIST_NAME, TRACK_NAME, RELEASE_DATE, GENRE, LEN, TOPIC, AGE) VALUES\n"
i = 0
for index, row in df.iterrows():
    string = string + "("+str(i).replace("'", "")+", '"+str(row.artist_name).replace("'", "")+"', '"+str(row.track_name).replace("'", "")+"', '"+str(row.release_date).replace("'", "")+"', '"+str(row.genre).replace("'", "")+"', "+str(row.leng).replace("'", "")+", '"+str(row.topic).replace("'", "")+"',"+str(row.age).replace("'", "")+"),\n"
    i = i + 1
    if i > 100:
        break

string_encode = string.encode("ascii", "ignore")
string_decode = string_encode.decode()

with open('music.txt', 'w') as f:
    f.write(string_decode)

print("Done")