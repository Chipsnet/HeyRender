# HeyRender

## これはなに

シンプルなレンダリング通知ソフトです。      
レンダリングが完了すると、自動的に通知を送ります。

## 機能

- Discord通知機能
- LINE Notify通知機能

## インストール

### 1. Javaをインストール

- Windows・Mac

[こちら](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)から、AdoptOpenJDKをダウンロードします。

[![Image from Gyazo](https://i.gyazo.com/21cb1cd4440704c8653525354e711708.png)](https://gyazo.com/21cb1cd4440704c8653525354e711708)

OpenJDK 11とHotSpotが選択されているのを確認して、Latest Releaseをクリックするとダウンロードされるので、インストーラに従ってインストールします。

- Linux (Ubuntu)

```bash
sudo add-apt-repository --yes ppa:rpardini/adoptopenjdk
sudo apt-get update
sudo apt-get install adoptopenjdk-11-jre-openj9-set-default
```

他のディストリビューションについては各自ググってください        
Java11が導入できれば大丈夫です

### 2. ダウンロード

[Release](https://github.com/Chipsnet/hey-render/releases)ページから、最新のものをダウンロードしてください。

ダウンロードするファイルは、Assetsの中の末尾が`.jar`のファイルです。        
例: `HeyRender_beta1.x.x.jar`

### 3. 起動

起動から動作に関しては[紹介ページ](https://lab.m86.work/2019/09/heyrender.html)を御覧ください。