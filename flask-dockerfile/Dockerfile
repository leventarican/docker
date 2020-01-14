# https://hub.docker.com/_/python?tab=description
FROM python:3

WORKDIR /app

COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

# only for interprocess
# EXPOSE 5000

CMD [ "python", "app.py" ]