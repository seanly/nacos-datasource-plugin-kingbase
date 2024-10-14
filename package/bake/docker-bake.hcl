variable "VERSION" {
  default = "2.4.1-2"
}

variable "DATABASE" {
  default = "kingbase8"
}

variable "FIXID" {
  default = "1"
}

group "default" {
  targets = ["nacos"]
}

target "nacos" {
    labels = {
        "cloud.opsbox.author" = "seanly"
        "cloud.opsbox.image.name" = "nacos"
        "cloud.opsbox.image.version" = "${VERSION}-${DATABASE}"
        "cloud.opsbox.image.fixid" = "${FIXID}"
    }
    dockerfile = "package/bake/Dockerfile"
    context  = "./"
    args = {
        NACOS_VERSION="${VERSION}"
    }
    platforms = ["linux/amd64", "linux/arm64"]
    tags = ["seanly/appset:nacos-${VERSION}-${DATABASE}-${FIXID}"]
    output = ["type=image,push=true"]
}
